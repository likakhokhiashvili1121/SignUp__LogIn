package com.example.signup__login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUpActivity2 : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    var databaseReference: DatabaseReference? = null
    var database: FirebaseDatabase? = null


    lateinit var signupButton: Button
    lateinit var username: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up2)
        supportActionBar?.hide()

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("profile")



        username = findViewById(R.id.username)
        signup1()
    }

    private fun signup1() {


        signupButton.setOnClickListener {

            val username = username.text.toString()


            if (username.isEmpty()) {
                Toast.makeText(this, "PLEASE, ENTER YOUR USERNAME", Toast.LENGTH_LONG).show()
            } else {

                Toast.makeText(this, "YOU ARE SIGNED IN!!", Toast.LENGTH_LONG)
                    .show()
            }
        }


        val signupsecond = findViewById<Button>(R.id.signupButton)
        signupsecond.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@SignUpActivity2, MainActivity::class.java)
            startActivity(intent)
        })

    }
}
