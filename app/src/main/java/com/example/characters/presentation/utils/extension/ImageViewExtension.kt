package com.example.characters.presentation.utils.extension

import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.characters.R

fun ImageView.convertToGrayscale() {
    val colorMatrix = ColorMatrix().apply {
        setSaturation(0f)
    }
    val colorFilter = ColorMatrixColorFilter(colorMatrix)
    this.colorFilter = colorFilter
}

fun ImageView.loadPhoto(
    url: String?,
    radius: Int = 1,
    placeholder: Int = R.drawable.ic_loading,
    error: Int = R.drawable.no_image
) {
    Glide.with(this.rootView)
        .load(url)
        .transform(RoundedCorners(radius))
        .placeholder(placeholder)
        .error(error)
        .into(this)
}
