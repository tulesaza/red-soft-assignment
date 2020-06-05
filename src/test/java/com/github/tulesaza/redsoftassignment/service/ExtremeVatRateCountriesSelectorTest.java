package com.github.tulesaza.redsoftassignment.service;

import com.github.tulesaza.redsoftassignment.exception.SelectorException;
import com.github.tulesaza.redsoftassignment.model.dto.Country;
import com.github.tulesaza.redsoftassignment.model.dto.ExtremeVatRateCountries;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExtremeVatRateCountriesSelectorTest {

    private final ExtremeVatRateCountriesSelector selector = new ExtremeVatRateCountriesSelector();

    /**
     * Expected Selector Exception when size of map is less than 4
     */
    @Test
    void negative_test() {
        Map<String, Country> input = generateMap(2);

        assertThrows(SelectorException.class, () -> selector.select(input));
    }

    /**
     * Expected ExtremeVatRateCountries containing countries with minimal and maximal VAT rate
     */
    @Test
    void positive_test() {
        Map<String, Country> input = generateMapWithExpectedExtremes();

        ExtremeVatRateCountries result = selector.select(input);

        assertEquals(10, result.getLowestVatCountry().getVatRate());
        assertEquals(11, result.getSecondLowestVatCountry().getVatRate());
        assertEquals(98, result.getHighestVatCountry().getVatRate());
        assertEquals(97, result.getSecondHighestVatCountry().getVatRate());
    }


    /**
     * Generates Map with defined size containing countries with random (20-80 %) VAT
     */
    private Map<String, Country> generateMap(int size) {
        Random random = new Random();
        Map<String, Country> result = new HashMap<>();
        for (int i = 0; i < size; i++) {
            result.put("C" + i, new Country("Country" + i, random.nextInt((80 - 20) + 1) + 20));
        }
        return result;
    }

    private Map<String, Country> generateMapWithExpectedExtremes() {
        Random random = new Random();
        Map<String, Country> result = generateMap(random.nextInt((30 - 2) + 1) + 2);
        result.put("E1", new Country("E1", 10));
        result.put("E2", new Country("E2", 11));
        result.put("E3", new Country("E3", 98));
        result.put("E4", new Country("E4", 97));
        return result;
    }
}