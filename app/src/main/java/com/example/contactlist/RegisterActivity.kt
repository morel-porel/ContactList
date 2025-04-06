package com.example.contactlist

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.contactlist.app.MyApp

class RegisterActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val username = findViewById<EditText>(R.id.etUsername)
        val password = findViewById<EditText>(R.id.etPassword)


        val btnRegister = findViewById<Button>(R.id.btnRegister)
        btnRegister.setOnClickListener {
            if(username.text.isEmpty()||password.text.isEmpty()){
                Toast.makeText(this, "Fill everything", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            (application as MyApp).username = username.text.toString()
            (application as MyApp).password = password.text.toString()

            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}