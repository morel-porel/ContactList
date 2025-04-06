package com.example.contactlist

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.contactlist.app.MyApp
import com.example.contactlist.data.Contact

class EditContactActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_contact)

        var fname = findViewById<EditText>(R.id.etFname)
        var mname = findViewById<EditText>(R.id.etMname)
        var lname = findViewById<EditText>(R.id.etLname)
        var email = findViewById<EditText>(R.id.etEmail)
        var number = findViewById<EditText>(R.id.etNumber)

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

        val btnSave = findViewById<Button>(R.id.btnSave)
        btnSave.setOnClickListener {
            contact.fname = fname.text.toString()
            contact.mname = mname.text.toString()
            contact.lname = lname.text.toString()
            contact.email = email.text.toString()
            contact.number = number.text.toString()
            (application as MyApp).contacts[position] = contact
            finish()
        }

        val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }
    }
}