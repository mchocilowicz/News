package com.mrch.backend.services;

import com.mrch.backend.models.NewsDTO;
import com.mrch.backend.models.responses.NewsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class NewsService {

    @Value("${newsapi.key}")
    private String key;

    @Autowired
    NewsTransformer newsTransformer;

    public NewsDTO getNewsByCountryCategory(String country, String category) {
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("newsapi.org/v2/top-headlines")
                .queryParam("country", country)
                .queryParam("category", category)
                .queryParam("apikey", key)
                .build();
        RestTemplate rest = new RestTemplate();
        NewsResponse response = rest.getForObject(uriComponents.toUriString(), NewsResponse.class);
        return newsTransformer.toNew(response, country, category);
    }
}
