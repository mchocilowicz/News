package com.mrch.backend.models.responses;

import java.io.Serializable;
import java.util.List;

public class NewsResponse implements Serializable {
    private String status;
    private Integer totalResults;
    private List<ArticleResponse> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public List<ArticleResponse> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleResponse> articles) {
        this.articles = articles;
    }
}

