package me.apomazkin.fundamentalproject.entity

class DataTool {
    companion object {
        fun getMovieList(): List<MovieItem> {
            val list = mutableListOf<MovieItem>()
            list.add(
                MovieItem(
                    title = "Avengers: End Game",
                    ageRating = 13,
                    isLiked = false,
                    genre = "Action, Adventure, Drama",
                    reviewCount = 125,
                    duration = 137,
                    poster = "example_movie_item_01"
                )
            )
            list.add(
                MovieItem(
                    title = "Tenet",
                    ageRating = 16,
                    isLiked = true,
                    genre = "Action, Sci-Fi, Thriller",
                    reviewCount = 98,
                    duration = 97,
                    poster = "example_movie_item_02"
                )
            )
            list.add(
                MovieItem(
                    title = "Black Widow",
                    ageRating = 13,
                    isLiked = false,
                    genre = "Action, Adventure, Sci-Fi",
                    reviewCount = 38,
                    duration = 102,
                    poster = "example_movie_item_03"
                )
            )
            list.add(
                MovieItem(
                    title = "Wonder Woman 1984",
                    ageRating = 13,
                    isLiked = false,
                    genre = "Action, Adventure, Fantasy",
                    reviewCount = 74,
                    duration = 120,
                    poster = "example_movie_item_04"
                )
            )

            return list
        }

        fun getActorList(): List<ActorItem> {
            val list = mutableListOf<ActorItem>()
            list.add(ActorItem("example_cast_1", "Robert Downey Jr."))
            list.add(ActorItem("example_cast_2", "Chris Evans"))
            list.add(ActorItem("example_cast_3", "Mark Ruffalo"))
            list.add(ActorItem("example_cast_4", "Chris Hemsworth"))
            return list
        }
    }
}