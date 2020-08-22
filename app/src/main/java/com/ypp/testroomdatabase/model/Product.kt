package com.ypp.testroomdatabase.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity(tableName = "book_table")
//class Book (
//    @PrimaryKey
//    @ColumnInfo(name = "book_name")
//    val bookName:String
@Entity(tableName = "product_table")
class Product (
    @PrimaryKey
    @ColumnInfo(name = "book_id")
    val id:Int,

    @ColumnInfo(name="name")
    val name:String,

    @ColumnInfo(name = "price")
    val price:Int,

    @ColumnInfo(name = "quantity")
    val quantity:Int
)