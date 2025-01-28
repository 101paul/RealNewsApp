package com.example.newsx_app.favaoriteF;

import androidx.room.TypeConverter;

import com.example.newsx_app.model.source;

public class sourceConverter {


    // Convert source object to a string (returning only the name field)
    @TypeConverter
    public static String fromSource(source source) {
        if (source == null) {
            return null;
        }
        return source.getName(); // Return the name field as a string
    }

    // Convert string back to a source object
    @TypeConverter
    public static source toSource(String sourceName) {
        if (sourceName == null) {
            return null;
        }
        // Assume the ID is null since only the name is stored
        return new source(null, sourceName);
    }
}
