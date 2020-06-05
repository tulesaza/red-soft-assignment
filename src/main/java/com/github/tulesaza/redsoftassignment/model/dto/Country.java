package com.github.tulesaza.redsoftassignment.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {

    @JsonProperty("country")
    private String name;

    @JsonProperty("standard_rate")
    private int vatRate;

    public Country() {

    }

    public Country(String name, int vatRate) {
        this.name = name;
        this.vatRate = vatRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVatRate() {
        return vatRate;
    }

    public void setVatRate(int vatRate) {
        this.vatRate = vatRate;
    }

    @Override
    public String toString() {
        return String.format("%s with %s%% VAT rate ", name, vatRate);
    }

}
