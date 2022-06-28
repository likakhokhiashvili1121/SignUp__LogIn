package com.example.signup__login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUpActivity : AppCompatActivity() {


    lateinit var auth: FirebaseAuth
    var databaseReference: DatabaseReference? = null
    var database: FirebaseDatabase? = null


    lateinit var nextButton: Button
    lateinit var email: EditText
    lateinit var password: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        supportActionBar?.hide()

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("profile")



        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        signup()
    }

    private fun signup() {

        nextButton.setOnClickListener {


            val email = email.text.toString()
            val password = password.text.toString()


            if (email.isEmpty() && password.isEmpty()) {
                Toast.makeText(this, "PLEASE, ENTER YOUR EMAIL AND PASSWORD", Toast.LENGTH_LONG)
                    .show()
            }

            if (email.contains("@")) {
                Toast.makeText(this, "EMAIL IS VALID! THANKS", Toast.LENGTH_LONG).show()

                if (email.isEmpty() || password.isEmpty())
                    Toast.makeText(this, "ENTER YOUR DATA IN BOTH FIELDS! !", Toast.LENGTH_LONG)
                        .show()


            } else {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val builder = AlertDialog.Builder(this)
                            builder.setTitle("! ! !")
                            builder.setMessage("YOU ARE SIGNED IN! YOUR PERSONAL DATA WILL BE PROTECTED IN THE DATABASE!")
                            builder.setPositiveButton("clear") { dialog, _ ->
                                dialog.dismiss()
                                startActivity(Intent(this, SignUpActivity2::class.java))
                                finish()
                            }
                            builder.show().setCanceledOnTouchOutside(false)
                        } else {
                            Toast.makeText(this, "CHECK ALL FIELDS!", Toast.LENGTH_LONG)
                                .show()
                        }
                    }
            }
        }


    }
}





