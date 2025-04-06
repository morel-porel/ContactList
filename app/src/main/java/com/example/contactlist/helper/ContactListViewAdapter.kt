package com.example.contactlist.helper

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import android.widget.TextView
import com.example.contactlist.ContactDetailActivity
import com.example.contactlist.R
import com.example.contactlist.data.Contact

class ContactListViewAdapter(
    var context:Context,
    var contacts: List<Contact>,
    var showAddDialogue:(Int)->Unit
    ) : BaseAdapter() {
    override fun getCount(): Int = contacts.size

    override fun getItem(position: Int): Any = contacts[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView ?: LayoutInflater.from(context).inflate(R.layout.contact_view, parent, false)

        var fname = view.findViewById<TextView>(R.id.tvFname)
        var mname = view.findViewById<TextView>(R.id.tvMname)
        var lname = view.findViewById<TextView>(R.id.tvLname)
        var email = view.findViewById<TextView>(R.id.tvEmail)
        var number = view.findViewById<TextView>(R.id.tvNumber)

        var contact = contacts[position]

        fname.setText(contact.fname)
        mname.setText(contact.mname)
        lname.setText(contact.lname)
        email.setText(contact.email)
        number.setText(contact.number)


        view.setOnClickListener {
            context.startActivity(Intent(context, ContactDetailActivity::class.java).apply {
                putExtra("position", position)
            })
        }
        view.setOnLongClickListener {
            showAddDialogue(position)
            true
        }


        return view
    }
}