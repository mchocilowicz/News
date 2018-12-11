package com.mrch.backend.services.impl;

import com.mrch.backend.models.NewsDTO;
import com.mrch.backend.models.responses.NewsResponse;
import com.mrch.backend.services.NewsService;
import com.mrch.backend.services.NewsTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
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
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme(scheme)
                .host("newsapi.org/v2/top-headlines")
                .queryParam("country", country)
                .queryParam("category", category)
                .queryParam("apikey", key)
                .build();
        RestTemplate rest = new RestTemplate();
        NewsResponse response = rest.getForObject(uriComponents.toUriString(), NewsResponse.class);
        return newsTransformer.toNewsDTO(response, country, category);
    }
}
