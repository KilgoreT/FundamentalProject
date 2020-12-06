package me.apomazkin.fundamentalproject

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.card.MaterialCardView

class FragmentMoviesList : Fragment() {

    private var listener: FragmentMoviesListListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<MaterialCardView>(R.id.card_item).setOnClickListener {
            listener?.onMovieSelect()
        }
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

    companion object {
        @JvmStatic
        fun newInstance() = FragmentMoviesList()
    }

    interface FragmentMoviesListListener {
        fun onMovieSelect()
    }
}