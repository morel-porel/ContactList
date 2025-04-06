package com.example.contactlist

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.contactlist.app.MyApp
import com.example.contactlist.data.Contact

class ContactDetailActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_detail)

        var fname = findViewById<TextView>(R.id.etFname)
        var mname = findViewById<TextView>(R.id.etMname)
        var lname = findViewById<TextView>(R.id.etLname)
        var email = findViewById<TextView>(R.id.etEmail)
        var number = findViewById<TextView>(R.id.etNumber)

        var contact = Contact("d","d","d","d","d")
        var position = 0

        intent?.let {
            it.getIntExtra("position", 0)?.let {i ->
                contact = (application as MyApp).contacts[i]
                position = i
            }
        }

        fname.setText(contact.fname)
        mname.setText(contact.mname)
        lname.setText(contact.lname)
        email.setText(contact.email)
        number.setText(contact.number)

        val btnEdit = findViewById<Button>(R.id.btnEdit)
        btnEdit.setOnClickListener {
            startActivity(Intent(this, EditContactActivity::class.java).apply {
                putExtra("position", position)
            })
            finish()
        }
        val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }

    }
}