package com.androiddevs.mvvmnewsapp.db

import android.content.Context
import androidx.room.*
import com.androiddevs.mvvmnewsapp.model.Article


@Database(
    entities = [Article::class], // Entities denotes the different tables in the database,
    // Currently we have only Article Table
    version = 2  // Version Number of the database.
)
@TypeConverters(Converter::class)
abstract class ArticleDatabase: RoomDatabase() {

    abstract fun articlesDao(): ArticlesDao

    companion object{
        @Volatile
        private var INSTANCE: ArticleDatabase? = null
//        private val LOCK = Any()

        operator fun invoke(context: Context) = INSTANCE ?: synchronized(this) {
            INSTANCE ?: createDatabase(context).also{
                instance ->
                INSTANCE = instance
            }
        }
        private fun createDatabase(context: Context)=
            Room.databaseBuilder(context.applicationContext,ArticleDatabase::class.java,"article_db.db")
                .build()
    }
}