package com.ypp.testroomdatabase.adaptor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ypp.testroomdatabase.R
import com.ypp.testroomdatabase.model.Product
import kotlinx.android.synthetic.main.item_result.view.*

class GetNameAdatper (var getNameList: List<Product>): RecyclerView.Adapter<GetNameAdatper.GetNameViewHolder>(){
    class  GetNameViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        fun  bindGetName(product: Product){
            itemView.idText.text=product.id.toString()
        }

    }

    fun updateList(productList: List<Product>){
        this.getNameList=productList
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GetNameViewHolder {
        var view= LayoutInflater.from(parent.context).inflate(R.layout.item_result, parent, false)
        return  GetNameViewHolder(view)
    }

    override fun getItemCount(): Int {
        return getNameList.size
    }

    override fun onBindViewHolder(holder: GetNameViewHolder, position: Int) {
        holder.bindGetName(getNameList[position])
    }
}