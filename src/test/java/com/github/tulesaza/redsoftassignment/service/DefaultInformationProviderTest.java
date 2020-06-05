package com.github.tulesaza.redsoftassignment.service;

import com.github.tulesaza.redsoftassignment.exception.DownloadException;
import com.github.tulesaza.redsoftassignment.model.dto.Country;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DefaultInformationProviderTest {

    private final InformationProvider provider = new DefaultInformationProvider();

    /**
     * Expected Download Exception when can't open the link
     */
    @Test
    void negative_test1() {

        assertThrows(DownloadException.class, () -> provider.download("http://nonexisted.com/cont")
        );
    }

    /**
     * Expected Download Exception when cannot deserialize content
     */
    @Test
    void negative_test2() throws MalformedURLException {

        String url = new File(getClass().getClassLoader().getResource("malformed_data.json").getFile()).toURI().toURL().toString();

        assertThrows(DownloadException.class, () -> provider.download(url)
        );
    }

    /**
     * Expected Map with size 3
     */
    @Test
    void positive_test() throws MalformedURLException {

        String url = new File(getClass().getClassLoader().getResource("good_data.json").getFile()).toURI().toURL().toString();

        Map<String, Country> result = provider.download(url);

        assertEquals(3, result.size());
    }
}