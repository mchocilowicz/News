package com.mrch.backend.services;

import com.mrch.backend.models.NewsDTO;

public interface NewsService {
    NewsDTO getNewsByCountryCategory(String country, String category);
    NewsDTO getNewsByConuntryAndQuery(String country, String query);
}
