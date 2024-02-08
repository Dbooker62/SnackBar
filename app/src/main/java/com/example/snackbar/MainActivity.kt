package com.example.snackbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    var listItems = ArrayList<String>()
    var adapter: ArrayAdapter<String>? = null
    lateinit var listview: ListView
    lateinit var fab: FloatingActionButton
    lateinit var undoOnClickListener: View.OnClickListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listview = findViewById(R.id.lv1)


        adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            listItems
        )
        listview.adapter = adapter

        fab = findViewById(R.id.fab)

        undoOnClickListener = View.OnClickListener {
            listItems.removeAt(listItems.size - 1)
            adapter?.notifyDataSetChanged()
            Snackbar.make(it, "Item Removed " , Snackbar.LENGTH_LONG)
                .setAction("set Action " , null)
                .show()
        }

        fab.setOnClickListener{
            addListItem()
            Snackbar.make(it , "Added an item",Snackbar.LENGTH_LONG)
                .setAction("UNDO", undoOnClickListener)
                .show()




    }


    }

    private fun addListItem()
    {
        listItems.add("Item ${listItems.size + 1}")
        adapter?.notifyDataSetChanged()
    }
}