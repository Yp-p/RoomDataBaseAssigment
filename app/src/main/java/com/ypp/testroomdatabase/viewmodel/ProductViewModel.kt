package com.ypp.testroomdatabase.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.ypp.testroomdatabase.database.ProductDatabase
import com.ypp.testroomdatabase.model.Product
import com.ypp.testroomdatabase.repository.ProductRepository
import kotlinx.coroutines.launch


class ProductViewModel(application: Application):AndroidViewModel(application){

    private val  repository:ProductRepository

    val allProduct:LiveData<List<Product>>
    init {
        val productDao=ProductDatabase.getDatabase(
            application
        ).productDao()
        repository= ProductRepository(productDao)
        allProduct=repository.allProduct
    }
    fun insert(product: Product)=viewModelScope.launch {
        repository.insert(product)
    }
    fun delete()=viewModelScope.launch {
        repository.delete()
    }
    fun deleteByID(id:Int)=viewModelScope.launch {
        repository.deleteByID(id)
    }
    fun getName(name:String)=viewModelScope.launch {
        repository.getName(name)
    }
}