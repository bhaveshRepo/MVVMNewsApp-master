package com.androiddevs.mvvmnewsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.androiddevs.mvvmnewsapp.model.Article

@Dao
interface ArticlesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long // Combination of Update & Insert, It will insert if New data , or Update it if already exists

    @Query("SELECT * FROM articles")
    fun getAllData(): LiveData<List<Article>>

    @Delete
    suspend fun deleteArticles(article: Article)

}
