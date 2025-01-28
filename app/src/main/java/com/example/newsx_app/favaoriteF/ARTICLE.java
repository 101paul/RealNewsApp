package com.example.newsx_app.favaoriteF;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.newsx_app.model.source ;
@Entity(tableName = "myarticle")

public class ARTICLE {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String url;
    private String imageUrl;
    private String source; // Store convertSource object

    public ARTICLE(String title,
                    String url, String imageUrl,
                   String source) {
        this.title = title;
        this.url = url;
        this.imageUrl = imageUrl;
        this.source = source;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
