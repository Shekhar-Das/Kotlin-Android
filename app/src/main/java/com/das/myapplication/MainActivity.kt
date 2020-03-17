package com.das.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnToast.setOnClickListener {
            Toast.makeText(this,"Button was clicked",Toast.LENGTH_SHORT).show()
            Log.i("MainActivity " ,"Button Clicked")
        }

        btnSendMessagetoSecondActivity.setOnClickListener {
            val message : String = EdMessage.text.toString()
            Toast.makeText(this , message , Toast.LENGTH_SHORT).show()
            val intent = Intent(this , SecondActivity::class.java)
            intent.putExtra("user_message",message)
            startActivity(intent)

        }

        btnShareToOtherApps.setOnClickListener {
            val message : String = EdMessage.text.toString()
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT , message)
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent , "Please select app"))
        }

    }
}
