package com.androiddevs.mvvmnewsapp.ui.fragment

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.androiddevs.mvvmnewsapp.R
import com.androiddevs.mvvmnewsapp.ui.MainActivity
import com.androiddevs.mvvmnewsapp.ui.NewsViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_article.*

class ArticleFragment : Fragment(R.layout.fragment_article) {

    lateinit var viewModel : NewsViewModel
    val args: ArticleFragmentArgs by navArgs() // SafeArgs working is return over here


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        val article = args.article
        webView.apply {                       // to open link into the web view and Not in the browser .
            webViewClient = WebViewClient()
            loadUrl(article.url)
        }
        fab.setOnClickListener{
            viewModel.saveArticle(article)
            Snackbar.make(view,"Article Saved",Snackbar.LENGTH_SHORT).apply {
                setAction("Undo"){
                    viewModel.deleteArticle(article)
                }
                show()
            }
        }
    }


}