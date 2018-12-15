package com.mrch.backend.controllers;

import com.mrch.backend.models.NewsDTO;
import com.mrch.backend.services.NewsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    NewsService newsService;

    @ApiOperation(value = "Get News by country and category", response = NewsDTO.class)
    @GetMapping("/{country}/{category}")
    public NewsDTO getNews(@PathVariable("country") String country, @PathVariable("category") String category) {
        return newsService.getNewsByCountryCategory(country, category);
    }

    @GetMapping("/{country}")
    @ApiOperation(value = "Get news for search query", response = NewsDTO.class)
    public NewsDTO getSearchResult(@PathVariable("country") String country,
                                   @ApiParam(value = "query to search news", required = true)
                                   @RequestParam("q") String query) {
        return newsService.getNewsByConuntryAndQuery(country, query);
    }
}
