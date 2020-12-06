package me.apomazkin.fundamentalproject.movieDetail

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
import me.apomazkin.fundamentalproject.entity.ActorItem

class ActorListAdapter :
    ListAdapter<ActorItem, ActorListAdapter.ActorItemHolder>(CustomDiffCallback<ActorItem>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorItemHolder {
        return ActorItemHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_actor, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ActorItemHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ActorItemHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(actorItem: ActorItem) {
            view.findViewById<TextView>(R.id.tv_cast_actor_holder).text = actorItem.name
            val id =
                view.resources.getIdentifier(actorItem.image, "drawable", view.context.packageName)
            view.findViewById<ImageView>(R.id.iv_cast_actor_holder)
                .setImageDrawable(ContextCompat.getDrawable(view.context, id))
        }
    }
}