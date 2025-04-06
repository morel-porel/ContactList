package com.example.contactlist.helper

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.contactlist.R
import com.example.contactlist.app.MyApp
import com.example.contactlist.data.Contact

class BlockedListViewAdapter(
    var context: Context,
    var contacts: List<Contact>,
    var showRemoveDialogue: (Int) -> Unit
    ) : BaseAdapter(){
    override fun getCount(): Int = contacts.size

    override fun getItem(position: Int): Any = contacts[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.contact_view, parent, false)

        var fname = view.findViewById<TextView>(R.id.tvFname)
        var mname = view.findViewById<TextView>(R.id.tvMname)
        var lname = view.findViewById<TextView>(R.id.tvLname)
        var email = view.findViewById<TextView>(R.id.tvEmail)
        var number = view.findViewById<TextView>(R.id.tvNumber)

        var contact = contacts[position]

        fname.setText(contact.fname)
        lname.setText(contact.lname)
        mname.setText(contact.mname)
        email.setText(contact.email)
        number.setText(contact.number)

        view.setOnClickListener {
            showRemoveDialogue(position)
        }
        return view
    }

}