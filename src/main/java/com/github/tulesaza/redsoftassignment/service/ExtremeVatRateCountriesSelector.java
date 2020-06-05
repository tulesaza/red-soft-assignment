package com.github.tulesaza.redsoftassignment.service;

import com.github.tulesaza.redsoftassignment.exception.SelectorException;
import com.github.tulesaza.redsoftassignment.model.dto.Country;
import com.github.tulesaza.redsoftassignment.model.dto.ExtremeVatRateCountries;
import org.apache.log4j.Logger;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExtremeVatRateCountriesSelector {

    private final static Logger LOG = Logger.getLogger(ExtremeVatRateCountriesSelector.class);

    public ExtremeVatRateCountries select(Map<String, Country> data) {

        if (data.size() < 4) {
            LOG.error("Unable to choose countries, their count must be at least 4");
            throw new SelectorException("Unable to choose countries, their count must be at least 4");
        }

        List<Country> countries = data
                .values()
                .stream()
                .sorted(Comparator.comparingInt(Country::getVatRate))
                .collect(Collectors.toList());
        int size = countries.size();

        return new ExtremeVatRateCountries(
                countries.get(0),
                countries.get(1),
                countries.get(size - 1),
                countries.get(size - 2));

    }
}
