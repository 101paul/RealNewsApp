package com.example.newsx_app.favaoriteF;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ARTICLE article);

    @Delete
    void delete(ARTICLE article);

    @Query("SELECT * FROM myarticle")
    List<ARTICLE> getAllArticles();
    @Query("DELETE FROM myarticle WHERE url = :articleUrl")
    void deleteByUrl(String articleUrl);
}
