package com.ypp.testroomdatabase.adaptor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ypp.testroomdatabase.R
import com.ypp.testroomdatabase.model.Product
import kotlinx.android.synthetic.main.activity_input.view.*
import kotlinx.android.synthetic.main.item_result.view.*

class ProductAdaptor:RecyclerView.Adapter<ProductAdaptor.ProductVIewHolder>() {
    private var list = emptyList<Product>()
    var clickListener:ClickListener ?= null
    fun onClickListener(clickListener: ClickListener){
        this.clickListener=clickListener
    }

    inner class ProductVIewHolder(itemView: View) :RecyclerView.ViewHolder(itemView),View.OnClickListener{
        init {
            itemView.setOnClickListener(this)
        }
        lateinit var product: Product
        fun bindProduct(product: Product){
            this.product=product
            itemView.idText.text=product.id.toString()
            itemView.nameText.text=product.name
            itemView.priceText.text=product.price.toString()
            itemView.quantityText.text=product.quantity.toString()

        }

        override fun onClick(p0: View?) {
            clickListener?.click(product)
        }

    }
    fun updateList(productList: List<Product>){
        this.list=productList
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductVIewHolder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.item_result,parent,false)
        return ProductVIewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ProductVIewHolder, position: Int) {
        holder.bindProduct(list[position])
    }
    interface ClickListener{
        fun click(product: Product)
    }
}