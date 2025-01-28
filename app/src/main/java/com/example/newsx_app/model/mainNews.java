package com.example.newsx_app.model;

import java.util.ArrayList;

public class mainNews {
    private String status ;
    private int totalResults ;
    private ArrayList<model> articles ;

    public mainNews(String status, int totalResults, ArrayList<model> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public ArrayList<model> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<model> articles) {
        this.articles = articles;
    }
}
