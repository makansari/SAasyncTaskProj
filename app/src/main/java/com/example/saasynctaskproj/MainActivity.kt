package com.example.saasynctaskproj

import android.app.ProgressDialog
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBarHorizontal.visibility = View.GONE
        progressBar.visibility = View.GONE

        buttonStart.setOnClickListener {

            progressBarHorizontal.setProgress(0)
            var mytask = MyAsyncTask()
            mytask.execute()

        }
    }


    inner class MyAsyncTask : AsyncTask<String, Int,String>(){

        val progressDialog = ProgressDialog(this@MainActivity)
        var counter = 10

        override fun onPreExecute() {
            super.onPreExecute()

            progressBar.visibility = View.VISIBLE

            progressBarHorizontal.visibility = View.VISIBLE

            progressDialog.setTitle("Image Downloading")
            progressDialog.setMessage("Plz wait.. Images downloading !!!")
            progressDialog.setIcon(R.drawable.cam)
            progressDialog.show()




        }

        override fun doInBackground(vararg params: String?): String {
             for(i in 0..10){
                 Thread.sleep(1000)

                 publishProgress(i + 25)

             }
            var someData = " Downloaded the images"
            return someData
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)

            var c  = values[0]
            var t : Int = c!!.toInt()
            textViewResult.setText("Downloading $c %")

            progressBarHorizontal.max = 100

            progressBarHorizontal.progress = t
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)

            progressBar.visibility = View.GONE

            progressDialog.cancel()

            textViewResult.setText(result)
        }

    }
}