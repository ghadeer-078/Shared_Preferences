package com.example.shared_preferences

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {

    lateinit var editText1: EditText
    lateinit var editText2: EditText
    lateinit var intentButton: Button
    lateinit var sharedButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectView()

        intentButton.setOnClickListener {
            startActivity(
                Intent(this, MainActivity2::class.java)
                    .putExtra("data", "${editText1.text} ${editText2.text}")
            )
        }

        //preference_file_key == craeted in string_file
        sharedButton.setOnClickListener {
            val sharePreferences = getSharedPreferences(
                getString(R.string.preference_file_key),
                Context.MODE_PRIVATE
            )
            with(sharePreferences.edit()) {
                putString("data", "${editText1.text} ${editText2.text}")
                apply()
            }
            startActivity(Intent(this, MainActivity2::class.java))
        }


    }

    private fun connectView() {
        editText1 = findViewById(R.id.editText1)
        editText2 = findViewById(R.id.editText2)
        intentButton = findViewById(R.id.intent_btn)
        sharedButton = findViewById(R.id.shared_btn)
    }


}