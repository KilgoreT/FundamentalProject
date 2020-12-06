package me.apomazkin.fundamentalproject.entity

data class MovieItem(
    val title: String,
    val reviewCount: Int,
    val ageRating: Int,
    val isLiked: Boolean,
    val genre: String,
    val duration: Int,
    val poster: String
)
