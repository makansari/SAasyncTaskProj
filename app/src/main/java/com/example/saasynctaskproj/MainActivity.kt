package com.example.saasynctaskproj

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar.visibility = View.GONE

        buttonStart.setOnClickListener {

            var mytask = MyAsyncTask()
            mytask.execute()

        }
    }


    inner class MyAsyncTask : AsyncTask<String, Int,String>(){

        override fun onPreExecute() {
            super.onPreExecute()

            progressBar.visibility = View.VISIBLE
        }

        override fun doInBackground(vararg params: String?): String {
             for(i in 0..10){
                 Thread.sleep(1000)

                 publishProgress(i)

             }
            var someData = " Downloaded the images"
            return someData
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)

            var c = values[0]
            textViewResult.setText("Downloading $c %")
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            progressBar.visibility = View.GONE
            textViewResult.setText(result)
        }

    }
}