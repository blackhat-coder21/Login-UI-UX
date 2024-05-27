package com.example.calldesk


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText


class Register : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val reg = findViewById<Button>(R.id.regbtn)
        val mail = findViewById<EditText>(R.id.email)
        val user_name = findViewById<EditText>(R.id.name)
        val pass = findViewById<EditText>(R.id.pwd)
        val cpass = findViewById<EditText>(R.id.cpwd)
        val mobile = findViewById<EditText>(R.id.mob)


        reg.setOnClickListener{
            val email = mail.text.toString()
            val name = user_name.text.toString()
            val pwd = pass.text.toString()
            val cpwd = cpass.text.toString()
            val phone = mobile.text.toString()
            var a = 0

//            if(email.isEmpty() || !email.contains("@")){
//                mail.error = "Invalid Email"
//                a = 1
//            }
//            if(name.isEmpty()){
//                user_name.error = "Invalid Name"
//                a = 1
//            }
//            if(pwd.isEmpty() || pwd.length<8){
//                pass.error = "Invalid Password"
//                a = 1
//            }
//            if(cpwd.isEmpty() || cpwd.length<8){
//                cpass.error = "Invalid Password"
//                a = 1
//            }
//            if(pwd!=cpwd){
//                cpass.error = "Password not matched"
//                a = 1
//            }
//            if(phone.isEmpty()){
//                mobile.error = "Invalid Mobile Number"
//                a = 1
//            }
            if(a==0){
                intent = Intent(applicationContext, Otp::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}