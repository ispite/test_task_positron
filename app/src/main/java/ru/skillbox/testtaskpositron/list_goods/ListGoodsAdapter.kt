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
    private val onItemClick: (gcode: Long) -> Unit
) : RecyclerView.Adapter<ListGoodsAdapter.ProductHolder>() {

    private var productList: List<Product> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return ProductHolder(itemView, onItemClick)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        val currentItem = productList[position]
        holder.titleProduct.text = currentItem.name
        holder.vendorCodeProduct.text = currentItem.gcode.toString()
        holder.priceProduct.text = currentItem.price.toString()

        Glide.with(holder.itemView)
            .load("https://vimos.ru/" + currentItem.img_preview)
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
        onItemClick: (gcode: Long) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        val titleProduct: TextView = itemView.titleProductTextView
        val priceProduct: TextView = itemView.priceProductTextView
        val vendorCodeProduct: TextView = itemView.vendorCodeProductTextView
        val imageProduct: ImageView = itemView.pictureProductImageView

        init {
            itemView.setOnClickListener {
                onItemClick(
                    vendorCodeProduct.text.toString().toLong()
                )
            }
        }
    }
}