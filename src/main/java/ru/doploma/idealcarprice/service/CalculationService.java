package ru.doploma.idealcarprice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.doploma.idealcarprice.dto.CalculationDTO;
import ru.doploma.idealcarprice.dto.CalculationDetailDTO;
import ru.doploma.idealcarprice.helper.SelectedItemsByUserHelper;
import ru.doploma.idealcarprice.model.*;
import ru.doploma.idealcarprice.parser.ParserSelenium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class CalculationService {
    private final SupplierSiteService supplierSiteService;
    private final SupplierXpathService supplierXpathService;
    private final RegulationsService regulationsService;

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
                if (!currentBodyWork.getName().equals("Замена элемента")) {
                    regulationsNamesAndServicePrices.put(currentBodyWork.getName(), currentBodyWork.getPrice().toString());
                }
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
        return new CalculationDTO(
                detailLinksAndPrices,
                regulationsNamesAndServicePrices,
                Double.parseDouble(carAveragePrice) + repairPrice,
                Double.parseDouble(carAveragePrice),
                repairPrice
        );
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
