package com.example.saasynctaskproj

import android.content.DialogInterface
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_run_time_per.*
import java.util.jar.Manifest

class RunTimePerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_run_time_per)

        buttongetPermission.setOnClickListener {
            //check whether the permission has been given by the user
            if(ActivityCompat.checkSelfPermission(this,
                    android.Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED ){

                Toast.makeText(this,"PERMISSION GRANTED",Toast.LENGTH_LONG).show()

            }else
            {
                // permission is not granted... we need to take the permsssion

                takingPermission()

            }


        }
    }

    private fun takingPermission() {

        Toast.makeText(this, "permision testing",Toast.LENGTH_SHORT).show()
        var arr  = arrayOf(android.Manifest.permission.SEND_SMS)
        if(ActivityCompat.shouldShowRequestPermissionRationale(this,android.Manifest.permission.SEND_SMS)){

            var alertBox = AlertDialog.Builder(this)
                .setTitle("ALERT !!")
                .setMessage("If you deny this permission, app cannot send SMS !!!")

                .setPositiveButton("ACCEPT_OK",DialogInterface.OnClickListener { dialog, which ->
                    ActivityCompat.requestPermissions(this,arr, 123)

                })

                .setNegativeButton("DENY_OK", DialogInterface.OnClickListener { dialog, which ->

                    dialog.cancel()
                })

            var ad = alertBox.create()
            ad.show()
        }

        else
        {
            ActivityCompat.requestPermissions(this,arr, 123)
        }
    }
}