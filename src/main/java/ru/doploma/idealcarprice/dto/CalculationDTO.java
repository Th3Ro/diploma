package ru.doploma.idealcarprice.dto;

import java.util.Map;

public class CalculationDTO {
    private Map<String, CalculationDetailDTO> detailLinksAndPrices;
    private Map<String, String> regulationsNamesAndServicePrices;
    private double totalCarPrice;
    private double averageCarPrice;
    private double repairPrice;

    public CalculationDTO (
            Map<String, CalculationDetailDTO> detailLinksAndPrices,
            Map<String, String> regulationsNamesAndServicePrices,
            double totalCarPrice,
            double averageCarPrice,
            double repairPrice) {
        this.detailLinksAndPrices = detailLinksAndPrices;
        this.regulationsNamesAndServicePrices = regulationsNamesAndServicePrices;
        this.averageCarPrice = averageCarPrice;
        this.totalCarPrice = totalCarPrice;
        this.repairPrice = repairPrice;
    }

    public Map<String, CalculationDetailDTO> getDetailLinksAndPrices() {
        return detailLinksAndPrices;
    }

    public Map<String, String> getRegulationsNamesAndServicePrices() {
        return regulationsNamesAndServicePrices;
    }

    public double getTotalCarPrice() {
        return totalCarPrice;
    }

    public double getAverageCarPrice() {
        return averageCarPrice;
    }

    public double getRepairPrice() {
        return repairPrice;
    }
}
