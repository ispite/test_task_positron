package ru.skillbox.testtaskpositron.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Product(
    val gcode: Long,
    val name: String,
    val price: Int,
    val img_preview: String
)
