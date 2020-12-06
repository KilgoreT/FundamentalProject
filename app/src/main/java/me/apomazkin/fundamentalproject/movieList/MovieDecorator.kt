package me.apomazkin.fundamentalproject.movieList

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import me.apomazkin.fundamentalproject.toPx

private const val SPACE = 16
private const val HALF_SPACE = SPACE / 2

class MovieDecorator : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.bottom = SPACE.toPx()
        if ((parent.getChildLayoutPosition(view) and 1) == 0) {
            outRect.left = SPACE.toPx()
            outRect.right = HALF_SPACE.toPx()
        } else {
            outRect.right = SPACE.toPx()
            outRect.left = HALF_SPACE.toPx()
        }
    }
}