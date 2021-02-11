package com.rabi.manu.model

data class Card(
    val type: String?,
    var imageId: Int = 0,
    var imageResId: Int = 0,
    var position: Int = -1,
    var question: String? = null,
    var isOnline:Boolean = true
)
