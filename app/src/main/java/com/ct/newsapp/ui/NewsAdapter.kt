package com.ct.newsapp.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ct.newsapp.MyApplication
import com.ct.newsapp.R
import com.ct.newsapp.model.Article

class NewsAdapter(private val articles: List<Article>, private val activity: MainActivity) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)
        return ViewHolder(view, activity)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = articles[position]
        holder.bind(article)
    }

    override fun getItemCount() = articles.size
}

class ViewHolder(itemView: View, private val activity: MainActivity) : RecyclerView.ViewHolder(itemView) {

    private val newsImage: ImageView = itemView.findViewById(R.id.ivNewsPicture)
    private val newsTitle: TextView = itemView.findViewById(R.id.tvTitle)

    fun bind(article: Article) {
        Glide.with(itemView).load(article.urlToImage).into(newsImage)
        newsTitle.text = article.title
        itemView.setOnClickListener {
            val newsFragment = DetailedNewsFragment()
            val bundle = Bundle()
            bundle.putSerializable("article", article)
            newsFragment.arguments = bundle
            activity.supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, newsFragment).addToBackStack(null).commit()
        }
    }
}
