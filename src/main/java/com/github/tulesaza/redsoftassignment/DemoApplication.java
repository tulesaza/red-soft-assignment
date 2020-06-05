package com.github.tulesaza.redsoftassignment;

import com.github.tulesaza.redsoftassignment.service.DefaultInformationProvider;
import com.github.tulesaza.redsoftassignment.service.ExtremeVatRateCountriesSelector;
import com.github.tulesaza.redsoftassignment.service.InformationProvider;
import org.apache.log4j.Logger;

public class DemoApplication {

    private final static Logger LOG = Logger.getLogger(InformationProvider.class);

    private static final String URL = "http://89.221.217.196:15500/countries";

    public static void main(String[] args) {
        InformationProvider provider = new DefaultInformationProvider();
        ExtremeVatRateCountriesSelector selector = new ExtremeVatRateCountriesSelector();
        try {
            System.out.println(selector.select(provider.download(URL)));
        } catch (Exception e) {
            LOG.error("Cannot print result due to", e);
        }
    }
}
