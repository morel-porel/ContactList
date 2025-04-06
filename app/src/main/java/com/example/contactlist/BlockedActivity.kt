package com.example.contactlist

import android.app.Activity
import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.contactlist.app.MyApp
import com.example.contactlist.helper.BlockedListViewAdapter

class BlockedActivity : Activity() {
    lateinit var listview: ListView
    lateinit var adapter: BlockedListViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blocked)

        listview = findViewById<ListView>(R.id.listview)
        adapter = BlockedListViewAdapter(this, (application as MyApp).blockContacts, ::showRemoveDialogue)
        listview.adapter = adapter



        val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }


    }
    private fun showRemoveDialogue(position: Int) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Remove from block list")

        builder.setPositiveButton("Remove"){_,_->
            val contact = (application as MyApp).blockContacts[position]
            (application as MyApp).blockContacts.remove(contact)
            (application as MyApp).contacts.add(contact)
            adapter.notifyDataSetChanged()
        }

        builder.setNegativeButton("Cancel", null)
        builder.show()
    }
}