package ru.skillbox.testtaskpositron.list_goods

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.skillbox.testtaskpositron.data.Product

class ListGoodsViewModel : ViewModel() {
    private val repository = ListGoodsRepository()

    private val _listGoods = MutableLiveData<List<Product>>()

    val listGoods : LiveData<List<Product>>
        get() = _listGoods

    fun getLinkDifferent() {
        viewModelScope.launch {
            try {
                _listGoods.postValue(repository.getLinkDifferent())
            } catch (t: Throwable) {
                Log.d("ListGoodsViewModel", "some Error: ", t)
            }
        }
    }
}