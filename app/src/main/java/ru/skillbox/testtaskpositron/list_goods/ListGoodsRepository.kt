package ru.skillbox.testtaskpositron.list_goods

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.skillbox.testtaskpositron.data.Product
import ru.skillbox.testtaskpositron.networking.Networking

class ListGoodsRepository {

    suspend fun getLinkDifferent(): List<Product> = withContext(Dispatchers.IO) {
        return@withContext Networking.api.getLinkDifferent("https://vimos.ru:1457/products?cat_id=869&limit=10&offset=0&base_id=1&sort_type=1")
    }
}