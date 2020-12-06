package me.apomazkin.fundamentalproject.movieList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import me.apomazkin.fundamentalproject.CustomDiffCallback
import me.apomazkin.fundamentalproject.R
import me.apomazkin.fundamentalproject.entity.MovieItem

class MovieListAdapter(val listener: MovieListAdapterListener) :
    ListAdapter<MovieItem, MovieListAdapter.MovieItemHolder>(CustomDiffCallback<MovieItem>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemHolder {
        return MovieItemHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_movie, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieItemHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class MovieItemHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        init {
            view.setOnClickListener {
                listener.onItemClick(getItem(adapterPosition).title)
            }
        }

        fun bind(movieItem: MovieItem) {
            view.findViewById<TextView>(R.id.tv_movie_title_movie_holder).text = movieItem.title
            view.findViewById<TextView>(R.id.tv_age_rating_movie_holder).text =
                view.resources.getString(R.string.movie_list_rating, movieItem.ageRating)
            val color =
                if (movieItem.isLiked) ContextCompat.getColor(
                    view.context,
                    R.color.clr_star_selected
                )
                else ContextCompat.getColor(view.context, R.color.clr_white)
            view.findViewById<ImageView>(R.id.iv_like_movie_holder)
                .setColorFilter(color, android.graphics.PorterDuff.Mode.SRC_IN)
            view.findViewById<TextView>(R.id.tv_genre_movie_holder).text = movieItem.genre
            view.findViewById<TextView>(R.id.tv_review_count_movie_holder).text =
                view.resources.getString(R.string.movie_detail_review_value, movieItem.reviewCount)
            view.findViewById<TextView>(R.id.tv_duration_movie_holder).text =
                view.resources.getString(R.string.movie_list_movie_duration, movieItem.duration)
            val id =
                view.resources.getIdentifier(movieItem.poster, "drawable", view.context.packageName)
            view.findViewById<ImageView>(R.id.iv_poster_movie_holder)
                .setImageDrawable(ContextCompat.getDrawable(view.context, id))
        }
    }

    interface MovieListAdapterListener {
        fun onItemClick(title: String)
    }
}