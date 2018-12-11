package com.mrch.backend.services;

import com.mrch.backend.models.ArticleDTO;
import com.mrch.backend.models.NewsDTO;
import com.mrch.backend.models.responses.ArticleResponse;
import com.mrch.backend.models.responses.NewsResponse;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsTransformer {

    public NewsDTO toNewsDTO(NewsResponse response, String country, String category) {
        List<ArticleDTO> articles = response.getArticles()
                .stream()
                .map(this::toArticleDTO)
                .collect(Collectors.toList());
        return new NewsDTO(country, category, articles);
    }

    public ArticleDTO toArticleDTO(ArticleResponse articleResponse) {
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setAuthor(articleResponse.getAuthor());
        articleDTO.setDescription(articleResponse.getDescription());
        articleDTO.setTitle(articleResponse.getTitle());
        articleDTO.setDate(transformDateFormat(articleResponse.getPublishedAt()));
        articleDTO.setArticleUrl(articleResponse.getUrl());
        articleDTO.setImageUrl(articleResponse.getUrlToImage());
        articleDTO.setSourceName(articleResponse.getSource().getName());
        return articleDTO;
    }

    public String transformDateFormat(String dateString) {
        String replace = dateString.replace("T", " ").replace("Z", "");
        SimpleDateFormat responseFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat dtoFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = responseFormat.parse(replace);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dtoFormat.format(date);
    }


}
