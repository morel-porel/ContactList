package com.example.contactlist

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.contactlist.app.MyApp
import com.example.contactlist.helper.ContactListViewAdapter

class HomeActivity : Activity() {
    lateinit var listview: ListView
    lateinit var adapter:ContactListViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        listview = findViewById<ListView>(R.id.listview)
        adapter = ContactListViewAdapter(this, (application as MyApp).contacts, ::showAddDialogue)
        listview.adapter = adapter

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        btnAdd.setOnClickListener {
            startActivity(Intent(this, AddActivity::class.java))
        }
        val btnProfile = findViewById<Button>(R.id.btnProfile)
        btnProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
        val btnBlock = findViewById<Button>(R.id.btnBlock)
        btnBlock.setOnClickListener {
            startActivity(Intent(this, BlockedActivity::class.java))
        }
    }

    private fun showAddDialogue(position: Int) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Block contact")
        builder.setPositiveButton("Block"){_,_ ->
            val contact = (application as MyApp).contacts[position]
            (application as MyApp).contacts.remove(contact)
            (application as MyApp).blockContacts.add(contact)
            adapter.notifyDataSetChanged()
        }
        builder.setNegativeButton("Cancel", null)
        builder.show()
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }
}