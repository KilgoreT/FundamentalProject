package me.apomazkin.fundamentalproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), FragmentMoviesList.FragmentMoviesListListener,
    FragmentMoviesDetails.FragmentMoviesDetailsListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment, FragmentMoviesList.newInstance())
                .commit()
        }
    }

    override fun onMovieSelect() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment, FragmentMoviesDetails.newInstance())
            .addToBackStack(null)
            .commit()
    }

    override fun onBackPress() {
        supportFragmentManager
            .popBackStack()
    }
}