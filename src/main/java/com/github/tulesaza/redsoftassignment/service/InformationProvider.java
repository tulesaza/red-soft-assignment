package com.github.tulesaza.redsoftassignment.service;

import com.github.tulesaza.redsoftassignment.model.dto.Country;

import java.util.Map;

public interface InformationProvider {

    Map<String, Country> download(String url);
}
