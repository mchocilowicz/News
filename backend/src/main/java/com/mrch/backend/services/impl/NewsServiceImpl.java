package com.mrch.backend.services.impl;

import com.mrch.backend.models.NewsDTO;
import com.mrch.backend.models.responses.NewsResponse;
import com.mrch.backend.services.NewsService;
import com.mrch.backend.services.NewsTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class NewsServiceImpl implements NewsService {

    @Value("${newsapi.key}")
    private String key;

    @Value("${newsapi.scheme}")
    private String scheme;

    @Value("${newsapi.host}")
    private String host;

    @Autowired
    NewsTransformer newsTransformer;

    public NewsDTO getNewsByCountryCategory(String country, String category) {
        if(isNumeric(country) || isNumeric(category)) {
            return new NewsDTO();
        }
        UriComponents uriComponent = UriComponentsBuilder.newInstance()
                .scheme(scheme)
                .host(host)
                .queryParam("country", country)
                .queryParam("category", category)
                .queryParam("apikey", key)
                .build();
        return getResponse(uriComponent.toUriString(), country, category);
    }

    @Override
    public NewsDTO getNewsForQuery(String query) {
        UriComponents uriComponent = UriComponentsBuilder.newInstance()
                .scheme(scheme)
                .host(host)
                .queryParam("q", query)
                .queryParam("apikey", key).build();
        return getResponse(uriComponent.toUriString(), null, null);
    }

    private NewsDTO getResponse(String url, String country, String category) {
        RestTemplate rest = new RestTemplate();
        NewsResponse response = rest.getForObject(url, NewsResponse.class);
        return newsTransformer.toNewsDTO(response, country, category);
    }

    private boolean isNumeric(String value) {
        boolean result = false;
        for (char c : value.toCharArray())
        {
            if (Character.isDigit(c)) result = true;
        }
        return result;
    }
}
