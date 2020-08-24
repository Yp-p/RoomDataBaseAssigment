package com.ypp.testroomdatabase.repository

import androidx.lifecycle.LiveData
import com.ypp.testroomdatabase.dao.ProductDao
import com.ypp.testroomdatabase.model.Product

//class BookRepository (private val bookDao: BookDao){
//    val allBook: LiveData<List<Book>> = bookDao.getAllBook()
//    suspend fun insert(book: Book){
//        bookDao.insert(book)
//    }
//
//    suspend fun delete(){
//        bookDao.deleteAll()
//    }
//    suspend fun deleteItem(name:String){
//        bookDao.deleteItem(name)
//    }
//    suspend fun updateItem(updateName:String, name: String){
//        bookDao.updateItem(updateName,name)
//    }
//}

class ProductRepository (private val productDao: ProductDao){
    val allProduct:LiveData<List<Product>> = productDao.getAllProduct()
//    lateinit var productByName

    suspend fun insert(product: Product){
        productDao.insert(product)
    }

    suspend fun delete(){
        productDao.deleteAll()
    }
    suspend fun deleteByID(id:Int){
        productDao.deleteID(id)
    }
    fun getName(name:String): LiveData<List<Product>>{
       var productByName: LiveData<List<Product>> = productDao.getProductName(name)
        return productByName
    }
}


