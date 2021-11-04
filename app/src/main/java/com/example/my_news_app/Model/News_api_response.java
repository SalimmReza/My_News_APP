package com.example.my_news_app.Model;

import java.util.List;

public class News_api_response {

    String status ;
    String totalResults ;

    List<News_Headlines> article;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public List<News_Headlines> getArticle() {
        return article;
    }

    public void setArticle(List<News_Headlines> article) {
        this.article = article;
    }
}
