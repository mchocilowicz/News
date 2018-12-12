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
        return newsService.getNewsByCountryCategory(country,category);
    }

    @GetMapping("/search")
    @ApiOperation(value = "Get news for search query", response = NewsDTO.class)
    @ApiParam("q")
    public NewsDTO getSearchResult(@RequestParam("q") String query) {
        return newsService.getNewsForQuery(query);
    }
}
