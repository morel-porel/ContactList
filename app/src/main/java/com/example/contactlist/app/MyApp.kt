package com.example.contactlist.app

import android.app.Application
import com.example.contactlist.data.Contact

class MyApp : Application(){
    var username = ""
    var password = ""
    var contacts = mutableListOf(
        Contact("Muriel", "Diongzon", "Pacio", "mp@mail.com", "0999999999")
    )
    var blockContacts = mutableListOf(
        Contact("Muriel", "Diongzon", "Pacio", "mp@mail.com", "0999999999")
    )

    override fun onCreate() {
        super.onCreate()
    }
}