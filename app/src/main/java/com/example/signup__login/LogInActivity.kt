package com.example.signup__login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LogInActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    private lateinit var inputEmail: EditText
    private lateinit var inputPassword: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        auth = FirebaseAuth.getInstance()
        supportActionBar?.hide()

        if (auth.currentUser != null) {
            startActivity(Intent(this@LogInActivity, MainActivity::class.java))
            finish()
        }

        setContentView(R.layout.activity_log_in)

        inputEmail = findViewById(R.id.email)
        inputPassword = findViewById(R.id.password)
        loginButton = findViewById(R.id.loginButton)


        loginButton.setOnClickListener {
            val email = inputEmail.text.toString()
            val password = inputPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "ENTER YOUR DATA IN BOTH FIELDS!", Toast.LENGTH_LONG).show()
            } else {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            startActivity(Intent(this, MainActivity::class.java))
                            finish()
                        } else {
                            Toast.makeText(this, "ERROR", Toast.LENGTH_LONG).show()
                        }
                    }
            }

        }
    }
}
