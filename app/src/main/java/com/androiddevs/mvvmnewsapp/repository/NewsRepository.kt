package com.androiddevs.mvvmnewsapp.repository

import com.androiddevs.mvvmnewsapp.api.RetrofitSingletonInstance
import com.androiddevs.mvvmnewsapp.db.ArticleDatabase
import com.androiddevs.mvvmnewsapp.model.Article

class NewsRepository (val db : ArticleDatabase) {

//   suspend fun getBreakingNews(country: String, pageNumber: Int) = RetrofitSingletonInstance.api.breakingNews(country,pageNumber)

suspend fun getBreakingNews(country: String, pageNumber: Int) = RetrofitSingletonInstance.api.breakingNews(country, pageNumber)

suspend fun getSearchNews(searchQuery: String, searchPage: Int) = RetrofitSingletonInstance.api.searchForNews(searchQuery,searchPage)

    suspend fun upsert(article: Article) = db.articlesDao().upsert(article)

    fun savedArticle() = db.articlesDao().getAllData()

    suspend fun deleteArticle(article: Article) = db.articlesDao().deleteArticles(article)


}