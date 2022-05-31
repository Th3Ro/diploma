package ru.doploma.idealcarprice.controler;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.doploma.idealcarprice.dto.CalculationDTO;
import ru.doploma.idealcarprice.dto.CalculationDetailDTO;
import ru.doploma.idealcarprice.helper.SelectedItemsByUserHelper;
import ru.doploma.idealcarprice.model.*;
import ru.doploma.idealcarprice.parser.ParserSelenium;
import ru.doploma.idealcarprice.service.RegulationsService;
import ru.doploma.idealcarprice.service.SupplierSiteService;
import ru.doploma.idealcarprice.service.SupplierXpathService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class CalculationController {
    private final SupplierSiteService supplierSiteService;
    private final SupplierXpathService supplierXpathService;
    private final RegulationsService regulationsService;

    @GetMapping("/calculation")
    public CalculationDTO getCalculationResult () {
        String carAveragePrice = ParserSelenium.parseAveragePrice(SelectedItemsByUserHelper.getSelectedModel().getAutoRuCode());
        SupplierSite supplierSite = supplierSiteService.findById(1L);
        SupplierXpath supplierXpath = supplierXpathService.findBySupplierSiteId(supplierSite.getId());
        Map<Long, List<PartCode>> selectedRegulations =  SelectedItemsByUserHelper.getSelectedPartCodesAndRegulations();
        Map<Long, BodyWork> selectedBodyWorks =  SelectedItemsByUserHelper.getSelectedBodyWorks();
        Map<String, CalculationDetailDTO> detailLinksAndPrices = new HashMap<>();
        Map<String, String> regulationsNamesAndServicePrices = new HashMap<>();
        for (Map.Entry<Long, List<PartCode>> entry: selectedRegulations.entrySet()) {
            Regulations regulations = regulationsService.findById(entry.getKey());
            if (regulations.isNeedBodyWork()) {
                BodyWork currentBodyWork = selectedBodyWorks.get(regulations.getId());
                regulationsNamesAndServicePrices.put(currentBodyWork.getName(), currentBodyWork.getPrice().toString());
            } else {
                regulationsNamesAndServicePrices.put(
                        regulations.getCriterionName(),
                        regulations.getServicePrice().getPrice().toString());
            }
            detailLinksAndPrices.putAll(ParserSelenium.parseDetailPrice(
                    supplierSite.getUrl(),
                    entry.getValue(),
                    "vendor_code",
                    supplierXpath.getValue()));
        }
        double repairPrice = getRepairPrice(detailLinksAndPrices, regulationsNamesAndServicePrices);
        CalculationDTO calculationDTO = new CalculationDTO(
                detailLinksAndPrices,
                regulationsNamesAndServicePrices,
                Double.parseDouble(carAveragePrice) + repairPrice,
                Double.parseDouble(carAveragePrice),
                repairPrice
            );
        return calculationDTO;
    }

    private double getRepairPrice (Map<String, CalculationDetailDTO> detailLinksAndPrices, Map<String, String> regulationsNamesAndServicePrices) {
        double repairPrice = 0;

        for (Map.Entry<String, CalculationDetailDTO> entry : detailLinksAndPrices.entrySet()) {
            repairPrice += entry.getValue().totalPrice;
        }

        for (Map.Entry<String, String> entry : regulationsNamesAndServicePrices.entrySet()) {
            repairPrice += Double.parseDouble(entry.getValue());
        }

        return repairPrice;
    }
}
