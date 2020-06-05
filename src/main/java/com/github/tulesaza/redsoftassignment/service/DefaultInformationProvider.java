package com.github.tulesaza.redsoftassignment.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tulesaza.redsoftassignment.exception.DownloadException;
import com.github.tulesaza.redsoftassignment.model.dto.Country;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.Map;

public class DefaultInformationProvider implements InformationProvider {

    private final static Logger LOG = LogManager.getLogger(InformationProvider.class);

    private final ObjectMapper mapper = new ObjectMapper();

    public Map<String, Country> download(String urlLink) {

        try {
            URL url = new URL(urlLink);
            return mapper.readValue(url, new TypeReference<>() {
            });
        } catch (Exception e) {
            LOG.error("Unable to download the data", e);
            throw new DownloadException("Unable to download the data", e);
        }
    }
}
