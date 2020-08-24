package com.ypp.testroomdatabase

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.ypp.testroomdatabase.adaptor.ProductAdaptor
import com.ypp.testroomdatabase.model.Product
import com.ypp.testroomdatabase.viewmodel.ProductViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_delete_id.*
import kotlinx.android.synthetic.main.item_delete_id.view.*

class MainActivity : AppCompatActivity() , ProductAdaptor.ClickListener{
    private  var addBookActivityRequestCode=1
   private lateinit var productAdaptor: ProductAdaptor
    private lateinit var productViewModel: ProductViewModel
    lateinit var product: Product
    lateinit var id:String
    lateinit var name:String
    lateinit var price:String
    lateinit var quantity:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    productViewModel= ViewModelProviders.of(this).get(ProductViewModel::class.java)
        productAdaptor= ProductAdaptor()
        recyclerResult.apply {
            layoutManager=GridLayoutManager(context,2)
            adapter=productAdaptor
        }

        productViewModel.allProduct.observe(
            this, Observer {product->
                product.let {
                    productAdaptor.updateList(product)
                }
            }
        )





        btnAdd.setOnClickListener{
            val intent=Intent(
                this,
                InputActivity::class.java
            )
            startActivityForResult(intent,addBookActivityRequestCode)
        }
        btndeleteAll.setOnClickListener {
            productViewModel.delete()
        }
        deleteById.setOnClickListener {

            val mDialogView=LayoutInflater.from(this).inflate(R.layout.item_delete_id,null)
            val mBuilder=AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("DELETE")
            val mAlertDialog=mBuilder.show()
            mDialogView.btnitem.setOnClickListener {
                mAlertDialog.dismiss()
                productViewModel.deleteByID(mDialogView.input.text.toString().toInt())
            }
        }

        btnMainGetName.setOnClickListener {
            var mDialogView=LayoutInflater.from(this).inflate(R.layout.item_delete_id,null)
            val mBuilder=AlertDialog.Builder(this)
            mBuilder.apply {
                setView(mDialogView)
                setTitle("GET")
            }
            val mAlertDialog=mBuilder.show()
            mAlertDialog.btnitem.setOnClickListener {
                mAlertDialog.dismiss()
                productViewModel.getName(mDialogView.input.text.toString())
                Toast.makeText(this, mDialogView.input.text, Toast.LENGTH_SHORT).show()
//                val intent= Intent(this, GetNameActivity::class.java)
//
//                startActivity(intent)
                productViewModel.getName(mDialogView.input.text.toString()).observe(
                    this, Observer {product->
                        product.let {
                            productAdaptor.updateList(product)
                        }
                    }
                )
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==addBookActivityRequestCode && resultCode==Activity.RESULT_OK){
            data?.getStringExtra(InputActivity.EXTRA_REPLY_ID)?.let {
                id=it
            }
            data?.getStringExtra(InputActivity.EXTRA_REPLY_NAME)?.let {
                name=it
            }
            data?.getStringExtra(InputActivity.EXTRA_REPLY_PEICE)?.let {
                price=it
            }
            data?.getStringExtra(InputActivity.EXTRA_REPLY_QUANTITY)?.let {
                quantity=it

            }
            productViewModel.insert(Product(id.toInt(),name,price.toInt(),quantity.toInt()))

        }
        productAdaptor.onClickListener(this)
    }

    override fun click(product: Product) {
        Toast.makeText(this, "Click", Toast.LENGTH_SHORT).show()


    }


}