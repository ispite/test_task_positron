package ru.skillbox.testtaskpositron.networking

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Url
import ru.skillbox.testtaskpositron.data.Product

interface Api {
    @GET
    suspend fun getLink(
        @Url url: String
    ): ResponseBody

    @GET
    suspend fun getLinkDifferent(
        @Url url: String
    ): List<Product>
}