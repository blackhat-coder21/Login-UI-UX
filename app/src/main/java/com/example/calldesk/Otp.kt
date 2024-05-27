package com.example.calldesk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast


class Otp : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)


        findViewById<Button>(R.id.verify).setOnClickListener{
            val otp1 = findViewById<EditText>(R.id.otp1).text.toString()
            val otp2 = findViewById<EditText>(R.id.otp2).text.toString()
            val otp3 = findViewById<EditText>(R.id.otp3).text.toString()
            val otp4 = findViewById<EditText>(R.id.otp4).text.toString()
            val verify_otp = findViewById<ProgressBar>(R.id.progress)
            val verify = findViewById<Button>(R.id.verify)



            if(otp1.isEmpty() || otp2.isEmpty() || otp3.isEmpty() || otp4.isEmpty()){
                Toast.makeText(this,"Enter OTP",Toast.LENGTH_SHORT).show()
            }
            else{
                verify_otp.visibility = View.VISIBLE
                verify.visibility =  View.INVISIBLE
                intent = Intent(applicationContext,Home::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}