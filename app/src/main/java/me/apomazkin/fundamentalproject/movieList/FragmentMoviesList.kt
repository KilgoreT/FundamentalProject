package me.apomazkin.fundamentalproject.movieList

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import me.apomazkin.fundamentalproject.R
import me.apomazkin.fundamentalproject.entity.DataTool

private const val SPAN_COUNT = 2

class FragmentMoviesList : Fragment(), MovieListAdapter.MovieListAdapterListener {

    private var listener: FragmentMoviesListListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_movie_list)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), SPAN_COUNT)
        val adapter = MovieListAdapter(this)
        recyclerView.adapter = adapter
        adapter.submitList(DataTool.getMovieList())
        recyclerView.addItemDecoration(MovieDecorator())
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentMoviesListListener) {
            listener = context
        } else {
            throw IllegalArgumentException("Activity doesn't implement FragmentMoviesListListener")
        }

    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onItemClick(title: String) {
        listener?.onMovieSelect()
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentMoviesList()
    }

    interface FragmentMoviesListListener {
        fun onMovieSelect()
    }
}