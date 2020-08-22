package com.ypp.testroomdatabase.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ypp.testroomdatabase.dao.ProductDao
import com.ypp.testroomdatabase.model.Product

@Database(entities = arrayOf(Product::class),version = 1)
abstract class ProductDatabase : RoomDatabase(){
    abstract fun productDao():ProductDao

    companion object{
        private var INSTANCE :ProductDatabase?=null
        fun getDatabase(context: Context):ProductDatabase{
            val tempInstance= INSTANCE
            if (tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance=Room.databaseBuilder(
                    context.applicationContext,
                    ProductDatabase::class.java,
                    "product_database"
                ).build()
                INSTANCE=instance
                return instance
            }
        }
    }

}