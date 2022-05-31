package ru.doploma.idealcarprice.dto;

public class CalculationDetailDTO {
    public double priceForOne;
    public int detailsCount;
    public double totalPrice;

    public CalculationDetailDTO (double priceForOne, int detailsCount) {
        this.priceForOne = priceForOne;
        this.detailsCount = detailsCount;
        this.totalPrice = priceForOne * detailsCount;
    }
}
