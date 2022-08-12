package com.example.when_where_whatv3;

import java.io.Serializable;
import java.util.List;

public class ApiResponse implements Serializable {

    String status = "";
    int totalResults;
    List<Headlines> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<Headlines> getArticles() {
        return articles;
    }

    public void setArticles(List<Headlines> articles) {
        this.articles = articles;
    }
}
