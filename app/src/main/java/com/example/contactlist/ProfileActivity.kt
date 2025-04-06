package com.example.contactlist

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.contactlist.app.MyApp

class ProfileActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val username = findViewById<EditText>(R.id.etUsername)
        val password = findViewById<EditText>(R.id.etPassword)

        username.setText((application as MyApp).username)
        password.setText((application as MyApp).password)


        val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }
        val btnSave = findViewById<Button>(R.id.btnSave)
        btnSave.setOnClickListener {
            (application as MyApp).username = username.text.toString()
            (application as MyApp).password = password.text.toString()
            finish()
        }
        val btnLogout = findViewById<Button>(R.id.btnLogout)
        btnLogout.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setPositiveButton("Logout of account"){_,_->
                startActivity(Intent(this, RegisterActivity::class.java))
                finish()
            }
            builder.setNegativeButton("Cancel",null)
            builder.show()
        }

    }
}