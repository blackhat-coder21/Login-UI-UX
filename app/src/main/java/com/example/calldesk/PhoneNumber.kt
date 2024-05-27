package com.example.calldesk


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle



class PhoneNumber : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_number)

//        val progress = findViewById<ProgressBar>(R.id.send_otp)
//        val send = findViewById<Button>(R.id.sendOTP)
//        val enternumber = findViewById<EditText>(R.id.number)


//        send.setOnClickListener{
//            progress.visibility = View.VISIBLE
//            send.visibility = View.INVISIBLE
//
//            PhoneAuthProvider.getInstance().verifyPhoneNumber(
//                "+91" + enternumber.getText().toString(),
//                60, TimeUnit.SECONDS,this,
//                PhoneAuthProvider.OnVerificationStateChangedCallbacks
//            )
//        }
//        send.setOnClickListener{
//            intent = Intent(applicationContext, Otp::class.java)
//            startActivity(intent)
//            finish()
//        }

    }
}