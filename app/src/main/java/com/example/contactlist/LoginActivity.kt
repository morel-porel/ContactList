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

class LoginActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val username = findViewById<EditText>(R.id.etUsername)
        val password = findViewById<EditText>(R.id.etPassword)

        username.setText((application as MyApp).username)
        password.setText((application as MyApp).password)

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            if(username.text.isEmpty()||password.text.isEmpty()){
                Toast.makeText(this, "Fill everything", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if(username.text.toString()!=(application as MyApp).username||password.text.toString()!=(application as MyApp).password){
                Toast.makeText(this, "Doesn't match", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}