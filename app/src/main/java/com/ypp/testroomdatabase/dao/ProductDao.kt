package com.ypp.testroomdatabase.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ypp.testroomdatabase.model.Product

//@Dao
//interface BookDao{
//    @Query("SELECT * FROM book_table ORDER BY book_name ASC")
//    fun getAllBook(): LiveData<List<Book>>
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    suspend fun insert(book: Book)
//
//    @Query("DELETE FROM book_table")
//    suspend fun deleteAll()
//
//    @Query("DELETE FROM book_table WHERE book_name=:name")
//    suspend fun deleteItem(name:String)
//
//    @Query("Update book_table SET book_name=:updateName Where book_name=:name")
//    suspend fun updateItem(updateName:String, name: String)
@Dao
interface ProductDao{
    @Query("SELECT * FROM product_table")
    fun getAllProduct():LiveData<List<Product>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(product: Product)

    @Query("DELETE FROM product_table")
    suspend fun deleteAll()

    @Query("DELETE FROM product_table WHERE book_id=:id")
    suspend fun deleteID(id:Int)

    @Query("SELECT * FROM product_table WHERE price BETWEEN 1000 AND 2000")
    suspend fun getProductRange(): List<Product>

    @Query("SELECT * FROM product_table Where name=:name")
     fun getProductName(name:String) : LiveData<List<Product>>


}