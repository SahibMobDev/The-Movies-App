package com.example.themoviesapp.screens.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.themoviesapp.BASE_URL
import com.example.themoviesapp.MAIN
import com.example.themoviesapp.R
import com.example.themoviesapp.models.MovieItemModel
import com.example.themoviesapp.models.MoviesModel
import kotlinx.android.synthetic.main.item_layout.view.*

class MainAdapter: RecyclerView.Adapter<MainAdapter.MyViewHolder>() {

    var listMovies = emptyList<MovieItemModel>()


    class MyViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.tv_title.text = listMovies[position].title
        holder.itemView.tv_date.text = listMovies[position].release_date

        Glide.with(MAIN).load("https://image.tmdb.org/t/p/w185/${listMovies[position].poster_path}")
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.itemView.item_img)
    }

    override fun getItemCount(): Int {
     return  listMovies.size
    }

    fun setList(list: List<MovieItemModel>) {
        listMovies = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: MyViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            MainFragment.clickMovie(listMovies[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: MyViewHolder) {
        holder.itemView.setOnClickListener(null)
    }
}