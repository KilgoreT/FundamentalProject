package me.apomazkin.fundamentalproject

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentMoviesDetails : Fragment() {

    private var listener: FragmentMoviesDetailsListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.tv_back_movie_detail).setOnClickListener {
            listener?.onBackPress()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentMoviesDetailsListener) {
            listener = context
        } else {
            throw IllegalArgumentException("Activity doesn't implement FragmentMoviesDetailsListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentMoviesDetails()
    }

    interface FragmentMoviesDetailsListener {
        fun onBackPress()
    }
}