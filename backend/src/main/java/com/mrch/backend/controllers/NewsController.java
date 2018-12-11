package com.mrch.backend.controllers;

import com.mrch.backend.models.NewsResponse;
import com.mrch.backend.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    NewsService newsService;

    @GetMapping("/{country}/{category}")
    public NewsResponse getNews(@PathVariable("country") String country, @PathVariable("category") String category) {
        return newsService.getNewsByCountryCategory(country,category);
    }
}
