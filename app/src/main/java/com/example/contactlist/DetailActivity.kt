@file:Suppress("DEPRECATION")

package com.example.contactlist
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity




    class DetailActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.item_detail)


            val itemModel = intent.getParcelableExtra<ItemModel>("itemModel")


            val textViewTitle = findViewById<TextView>(R.id.textViewTitle)
            textViewTitle.text =
                "${itemModel?.id}\n${itemModel?.fullname}\n${itemModel?.phone}\n${itemModel?.mail}"
        }
    }

