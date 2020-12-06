package me.apomazkin.fundamentalproject.movieDetail

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import me.apomazkin.fundamentalproject.toPx

private const val SPACE = 16
private const val HALF_SPACE = SPACE / 2
private const val ZERO_SPACE = 0
private const val FIRST_ITEM = 0
private const val LAST_ITEM = 1

class ActorDecorator : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.top = SPACE.toPx()
        outRect.bottom = SPACE.toPx()
        if (parent.getChildLayoutPosition(view) == FIRST_ITEM) {
            outRect.left = SPACE.toPx()
        } else {
            outRect.left = HALF_SPACE.toPx()
        }
        parent.adapter?.let {
            if (parent.getChildLayoutPosition(view) == it.itemCount - LAST_ITEM) {
                outRect.right = SPACE.toPx()
            } else {
                outRect.right = ZERO_SPACE
            }
        }
    }
}