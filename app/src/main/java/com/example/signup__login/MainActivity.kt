package com.example.signup__login


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        var open=findViewById<Button>(R.id.registerButton)
        open.setOnClickListener(View.OnClickListener {
            var intent = Intent(this@MainActivity, SignUpActivity::class.java)
            startActivity(intent)
        })


        var secondopen=findViewById<Button>(R.id.loginButton)
        secondopen.setOnClickListener(View.OnClickListener {
            var intent = Intent(this@MainActivity, LogInActivity::class.java)
            startActivity(intent)
        })

    }

}