package com.example.saasynctaskproj

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Toast
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_third.*

class ThirdAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        var arr  = arrayOf(android.Manifest.permission.SEND_SMS)
        ActivityCompat.requestPermissions(this,arr, 123)

        buttonSms.setOnClickListener {

            var smsManager = SmsManager.getDefault()
            smsManager.sendTextMessage("5554",
                null,"Welcome to Android Ansari",null,null)
        }

       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            ActivityCompat.requestPermissions(this,arr, 123)
        }
       else{

       }*/
/*
        if(ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,arr, 123)

Toast.makeText(this,"PERMISSION GRANTED ... ",Toast.LENGTH_SHORT).show()

        } else
        {
            Toast.makeText(this,"PERMISSION not gramted ... ",Toast.LENGTH_SHORT).show()

        }*/
    }
}