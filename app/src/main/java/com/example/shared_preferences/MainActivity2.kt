package com.example.shared_preferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var spButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        connectView()

        textView.text = intent.getStringExtra("data")

        //preference_file_key == created in string_file
        val sharePreferences = getSharedPreferences(
            getString(R.string.preference_file_key),
            Context.MODE_PRIVATE
        )


        spButton.setOnClickListener {
            textView.text = sharePreferences.getString("data", "")
        }

    }


    private fun connectView() {
        textView = findViewById(R.id.textView)
        spButton = findViewById(R.id.sp_btn)
    }


}

