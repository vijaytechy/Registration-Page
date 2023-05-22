package com.example.pass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)


        val name = intent.getStringExtra(signIn.KEY)
        val emailid = intent.getStringExtra(signIn.KEY1)
        val userid = intent.getStringExtra(signIn.KEY2)

        val welcome = findViewById<TextView>(R.id.txt1)
        val mailtxt = findViewById<TextView>(R.id.txt3)
        val idtxt = findViewById<TextView>(R.id.txt4)
        mailtxt.text="mail :$emailid"
        idtxt.text="userid :$userid"
        welcome.text="welcome: $name"

    }
}