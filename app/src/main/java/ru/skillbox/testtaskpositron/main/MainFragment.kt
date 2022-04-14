package ru.skillbox.testtaskpositron.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_main.*
import ru.skillbox.testtaskpositron.R

class MainFragment:Fragment(R.layout.fragment_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        moveToCatalogButton.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToListGoodsFragment()
            findNavController().navigate(action)
        }
    }
}