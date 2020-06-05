package com.github.tulesaza.redsoftassignment.model.dto;

public class ExtremeVatRateCountries {

    private final Country lowestVatCountry;

    private final Country secondLowestVatCountry;

    private final Country highestVatCountry;

    private final Country secondHighestVatCountry;

    public Country getLowestVatCountry() {
        return lowestVatCountry;
    }

    public Country getSecondLowestVatCountry() {
        return secondLowestVatCountry;
    }

    public Country getHighestVatCountry() {
        return highestVatCountry;
    }

    public Country getSecondHighestVatCountry() {
        return secondHighestVatCountry;
    }

    public ExtremeVatRateCountries(Country lowestVatCountry, Country secondLowestVatCountry,
                                   Country highestVatCountry, Country secondHighestVatCountry) {
        this.lowestVatCountry = lowestVatCountry;
        this.highestVatCountry = highestVatCountry;
        this.secondLowestVatCountry = secondLowestVatCountry;
        this.secondHighestVatCountry = secondHighestVatCountry;
    }


    @Override
    public String toString() {
        return String.format("Lowest VAT is in %s\nSecond Lowest VAT is in %s\nHighest VAT is in %s\nSecond Highest VAT is in %s\n",
                lowestVatCountry, secondLowestVatCountry, highestVatCountry, secondHighestVatCountry);
    }

}
