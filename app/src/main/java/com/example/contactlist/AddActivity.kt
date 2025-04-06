package com.example.contactlist

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.contactlist.app.MyApp
import com.example.contactlist.data.Contact

class AddActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        var fname = findViewById<TextView>(R.id.etFname)
        var mname = findViewById<TextView>(R.id.etMname)
        var lname = findViewById<TextView>(R.id.etLname)
        var email = findViewById<TextView>(R.id.etEmail)
        var number = findViewById<TextView>(R.id.etNumber)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        btnAdd.setOnClickListener {
            (application as MyApp).contacts.add(
                Contact(
                    fname.text.toString(),
                    mname.text.toString(),
                    lname.text.toString(),
                    email.text.toString(),
                    number.text.toString()
                )
            )
            finish()
        }
    }
}