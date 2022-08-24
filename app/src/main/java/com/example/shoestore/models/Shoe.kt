package com.example.shoestore.models

import android.graphics.Bitmap

data class Shoe(
    var name: String, var size: Double?, var company: String, var description: String,
    val image: Bitmap
) {
}
