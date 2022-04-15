package ru.skillbox.testtaskpositron.list_goods

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_card.view.*
import ru.skillbox.testtaskpositron.R
import ru.skillbox.testtaskpositron.data.Product

class ListGoodsAdapter(
    private val onItemClick: (gcode: Long, title: String, price: Int, pictureLink: String) -> Unit
) : RecyclerView.Adapter<ListGoodsAdapter.ProductHolder>() {

    private var productList: List<Product> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return ProductHolder(itemView, onItemClick)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        val currentItem = productList[position]
        holder.titleProductTV.text = currentItem.name
        holder.vendorCodeProductTV.text = currentItem.gcode.toString()
        holder.priceProductTV.text = currentItem.price.toString()

        holder.priceProduct = currentItem.price
        holder.vendorCode = currentItem.gcode
        holder.pictureLink= ("https://vimos.ru/" + currentItem.img_preview)
        Glide.with(holder.itemView)
            .load(holder.pictureLink)
            .placeholder(R.drawable.ic_broken_image)
            .into(holder.imageProduct)
    }

    override fun getItemCount(): Int = productList.count()

    fun setProductList(productList: List<Product>) {
        this.productList = productList
        notifyDataSetChanged()
    }

    class ProductHolder(
        itemView: View,
        onItemClick: (gcode: Long, title: String, price: Int, pictureLink: String) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        val titleProductTV: TextView = itemView.titleProductTextView
        val priceProductTV: TextView = itemView.priceProductTextView
        val vendorCodeProductTV: TextView = itemView.vendorCodeProductTextView
        val imageProduct: ImageView = itemView.pictureProductImageView

        var priceProduct: Int = 0
        var vendorCode: Long = 0
        var pictureLink: String = ""

        init {
            itemView.setOnClickListener {
                onItemClick(
                    vendorCode,
                    titleProductTV.text.toString(),
                    priceProduct,
                    pictureLink
                )
            }
        }
    }
}