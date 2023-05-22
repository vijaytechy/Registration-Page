package com.example.pass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Contacts.SettingsColumns.KEY
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.security.Key

    private lateinit var databaseReference: DatabaseReference

class signIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val user = findViewById<TextInputEditText>(R.id.userId)
        val pass = findViewById<TextInputEditText>(R.id.pass)
        val signin = findViewById<Button>(R.id.btn)

        signin.setOnClickListener{

            val userid = user.text.toString()
            val password = user.text.toString()
            if(userid.isNotEmpty() && password.isNotEmpty()){
                readData(userid)
            }else{
                Toast.makeText(this,"please enter your userId",Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun readData(userid: String) {
        databaseReference = FirebaseDatabase.getInstance().getReference("users")
        databaseReference.child(userid ).get().addOnSuccessListener {
            if(it.exists()){

                val emailid = it.child("emailid").value
                val name = it.child("name").value
                val userid = it.child("userid").value

                val intentwelcome = Intent(this,welcome::class.java)

                intentwelcome.putExtra(KEY1,emailid.toString())
                intentwelcome.putExtra(KEY,name.toString())
                intentwelcome.putExtra(KEY2,userid.toString())
                startActivity(intentwelcome)
            }else{
                Toast.makeText(this,"User Doest Not Exist",Toast.LENGTH_SHORT).show()
            }

        }.addOnFailureListener{
            Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
    const val KEY = "com.example.pass.signIn.name"
        const val KEY1 = "com.example.pass.signIn.emailid"
        const val KEY2 = "com.example.pass.signIn.userid"


    }
}