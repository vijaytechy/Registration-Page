package com.example.pass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    lateinit var Database :DatabaseReference;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etnames = findViewById<TextInputEditText>(R.id.name)
        val etemail = findViewById<TextInputEditText>(R.id.eid)
        val etuserid = findViewById<TextInputEditText>(R.id.uid)
        val signup = findViewById<Button>(R.id.btn)
        val etpass = findViewById<TextInputEditText>(R.id.pass)

        signup.setOnClickListener{

            val name=etnames.text.toString()
            val mail=etemail.text.toString()
            val userid=etuserid.text.toString()
            val password = etpass.text.toString()



        val Users = user(name, mail ,userid,password)
            Database = FirebaseDatabase.getInstance().getReference("users")
            Database.child(userid).setValue(Users).addOnSuccessListener {
                etnames.text?.clear()
                etemail.text?.clear()
                etuserid.text?.clear()
                etpass.text?.clear()
                Toast.makeText(this,"user registered successfully",Toast.LENGTH_SHORT).show()
            }
                .addOnSuccessListener {
                    Toast.makeText(this,"registration failed",Toast.LENGTH_SHORT).show()
                }
        }
        val signIntxt = findViewById<TextView>(R.id.tvs)

        signIntxt.setOnClickListener{
            val signinpage = Intent(this,signIn::class.java)
            startActivity(signinpage)
        }
            }


}