package com.example.newsx_app.favaoriteF;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {ARTICLE.class}, version = 1)
//@TypeConverters(sourceConverter.class) // Register the TypeConverter here

public abstract class roomDB extends RoomDatabase {
    private static roomDB INSTANCE;
    public abstract DAO favoriteArticleDao() ;
    public static synchronized roomDB getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            roomDB.class, "database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }

}
