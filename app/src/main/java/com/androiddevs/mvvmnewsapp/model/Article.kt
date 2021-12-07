package com.androiddevs.mvvmnewsapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

// Data class is also known as Model class
// it is created , so that Application which data and in which type should be retrieved from the API


@Entity(
tableName = "articles"
)
data class Article(
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null,
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: Source?, // Room only understands Primitive Data type , so for source
    // we have to include type converter
    val title: String?,
    val url: String?,
    val urlToImage: String?
) : Serializable