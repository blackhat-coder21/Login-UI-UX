package com.example.calldesk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import com.google.firebase.database.DatabaseReference

class LoginPage : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        supportActionBar?.hide()
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        val login = findViewById<Button>(R.id.btnlogin)
        val user = findViewById<EditText>(R.id.email)
        val pwd = findViewById<EditText>(R.id.pwd)
        val sign_up = findViewById<Button>(R.id.btn_sign)

        login.setOnClickListener {
            val user_data = user.text.toString()
            val pwd_data = pwd.text.toString()


            if (user_data.isEmpty() || !user_data.contains("@")) {
                user.error = "Invalid Email"
            }
            if (pwd_data.isEmpty() || pwd_data.length<8) {
                pwd.error = "Password Required"
            }
            else {
                intent = Intent(applicationContext, Home::class.java)
                startActivity(intent)
                finish()
            }
        }

        sign_up.setOnClickListener{
            intent = Intent(applicationContext, Register::class.java)
            startActivity(intent)
            finish()
        }
    }
}