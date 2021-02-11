package com.rabi.manu.utils

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.ImageView
import com.bumptech.glide.Glide


fun ImageView?.load(resource: Any) {
    Glide.with(this!!)
        .load(resource)
        .placeholder(ColorDrawable(Color.BLACK))
        .error( ColorDrawable(Color.RED))
        .fallback(ColorDrawable(Color.GRAY))
        .into(this)
}

