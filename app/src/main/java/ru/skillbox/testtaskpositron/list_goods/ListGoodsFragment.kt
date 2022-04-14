package ru.skillbox.testtaskpositron.list_goods

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list_goods.*
import ru.skillbox.testtaskpositron.R
import ru.skillbox.testtaskpositron.utils.autoCleared

class ListGoodsFragment:Fragment(R.layout.fragment_list_goods) {

    private val viewModel by viewModels<ListGoodsViewModel>()
    private var productsAdapter: ListGoodsAdapter by autoCleared()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
        bindViewModel()
        viewModel.getLinkDifferent()
    }

    private fun initList() {
        productsAdapter = ListGoodsAdapter {
            val action = ListGoodsFragmentDirections.actionListGoodsFragmentToDetailsProductFragment()
            findNavController().navigate(action)
        }
        with(listGoodsRecyclerView) {
            adapter = productsAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }
    }

    private fun bindViewModel() {
        viewModel.listGoods.observe(viewLifecycleOwner) {
            productsAdapter.setProductList(it)
        }
    }
}