package me.apomazkin.fundamentalproject

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil


@SuppressLint("DiffUtilEquals")
class CustomDiffCallback<T> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T) = oldItem == newItem
    override fun areContentsTheSame(oldItem: T, newItem: T) = oldItem == newItem
}