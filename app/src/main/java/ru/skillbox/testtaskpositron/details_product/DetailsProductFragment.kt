package ru.skillbox.testtaskpositron.details_product

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_details_product.*
import ru.skillbox.testtaskpositron.R

class DetailsProductFragment: Fragment(R.layout.fragment_details_product) {

    private val args: DetailsProductFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        titleProductTextView.text = args.title
        priceProductTextView.text = args.price.toString()
        vendorCodeProductTextView.text = args.gcode.toString()

        Glide.with(view)
            .load(args.pictureLink)
            .placeholder(R.drawable.ic_broken_image)
            .into(pictureProductImageView)
    }
}