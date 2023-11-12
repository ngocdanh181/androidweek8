package com.example.contactlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.View
import android.widget.ListView
import android.view.MenuItem
import android.widget.AdapterView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val items = arrayListOf<ItemModel>()
        items.add(ItemModel(1, "D","Hoang Ngoc Danh","0123456789","ngocdanh@gmail.com"))
        items.add(ItemModel(2, "L","Nguyen Van Love","0123456789","vanlove@gmail.com"))
        items.add(ItemModel(3, "N","Nguyen Quynh Nhu","0123456789","quynhnhu@gmail.com"))
        items.add(ItemModel(1, "D","Hoang Ngoc Danh","0123456789","ngocdanh@gmail.com"))
        items.add(ItemModel(1, "D","Hoang Ngoc Danh","0123456789","ngocdanh@gmail.com"))
        items.add(ItemModel(1, "D","Hoang Ngoc Danh","0123456789","ngocdanh@gmail.com"))
        items.add(ItemModel(1, "D","Hoang Ngoc Danh","0123456789","ngocdanh@gmail.com"))
        items.add(ItemModel(1, "D","Hoang Ngoc Danh","0123456789","ngocdanh@gmail.com"))
        val listView = findViewById<ListView>(R.id.list_view)
        listView.adapter = ItemAdapter(items)

        listView.setOnItemClickListener { parent, view, position, id ->
            val selectedItem = items[position]
            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            intent.putExtra("itemModel", selectedItem)
            startActivity(intent)
        }



        registerForContextMenu(findViewById(R.id.list_view))
        }

        override fun onCreateContextMenu(
            menu: ContextMenu?,
            v: View?,
            menuInfo:ContextMenu.ContextMenuInfo
        ){
            super.onCreateContextMenu(menu, v, menuInfo)
            menuInflater.inflate(R.menu.main_menu, menu)
        }
        override fun onContextItemSelected(item: MenuItem): Boolean {
            val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
            val position = info.position
            val adapter = (findViewById<ListView>(R.id.list_view).adapter) as ItemAdapter
            val selectedItem = adapter.getItem(position) as ItemModel
            return when (item.itemId) {
                R.id.action_call -> {
                    true
                }

                R.id.action_sendmess -> {
                    true
                }

                R.id.action_sendmail -> {
                    true
                }
                else -> super.onContextItemSelected(item)
            }
        }
    }