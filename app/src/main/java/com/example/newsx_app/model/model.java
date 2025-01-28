package com.example.newsx_app.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.io.Serializable;

public class model{
    public int id ;
    public source source ;
    private String auther , title , description , url ,  urlToImage ,  publishedAt ;
    public model(String auther, String title, String description, String url, String urlToImage, String publishedAt, source source) {
        this.auther = auther;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.source = source ;
    }

    public source getSource() {
        return source;
    }

    public void setSource(source source) {
        this.source = source;
    }

    public String getAuther() {
        return auther;
    }
    public void setAuther(String auther) {
        this.auther = auther;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getUrlToImage() {
        return urlToImage;
    }
    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }
    public String getPublishedAt() {
        return publishedAt;
    }
    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }
}
