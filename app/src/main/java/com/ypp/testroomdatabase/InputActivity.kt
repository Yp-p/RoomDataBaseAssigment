package com.ypp.testroomdatabase

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.ypp.testroomdatabase.model.Product
import kotlinx.android.synthetic.main.activity_input.*

class InputActivity : AppCompatActivity() {
    lateinit var id:String
    lateinit var name:String
    lateinit var price:String
    lateinit var quantity:String
   // lateinit var product: Product

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        btnSummit.setOnClickListener{
            val replyIntent=Intent()
            id=idInsert.text.toString()
            name=nameInsert.text.toString()

            if (TextUtils.isEmpty(idInsert.text)){
            setResult(Activity.RESULT_CANCELED, replyIntent)
            } else{
                id=idInsert.text.toString()
                name=nameInsert.text.toString()
                price=priceInsert.text.toString()
                quantity=quantityInsert.text.toString()
                replyIntent.putExtra(EXTRA_REPLY_ID,id)
                replyIntent.putExtra(EXTRA_REPLY_NAME,name)
                replyIntent.putExtra(EXTRA_REPLY_PEICE,price)
                replyIntent.putExtra(EXTRA_REPLY_QUANTITY,quantity)

                setResult(Activity.RESULT_OK,replyIntent)
            }
            finish()
        }

    }
    companion object{
        const val EXTRA_REPLY_ID="REPLY ID"
        const val EXTRA_REPLY_NAME="REPLY NAME"
        const val EXTRA_REPLY_PEICE="REPLY PRICE"
        const val EXTRA_REPLY_QUANTITY="REPLY QUANTITY"
    }


}