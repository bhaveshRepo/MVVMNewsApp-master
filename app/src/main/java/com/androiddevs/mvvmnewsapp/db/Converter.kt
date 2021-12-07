package com.androiddevs.mvvmnewsapp.db

import androidx.room.TypeConverter
import com.androiddevs.mvvmnewsapp.model.Source


class Converter {
    @TypeConverter // Class that is carrying put converting function is annotated
    // using @TypeConverter where in database @TypeConverters annotation is Used
    fun fromSource(source: Source) : String{ // Take arguments of Type Source
        //which are id and name and return in string format
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source{

        return Source(name, name)
    }



}