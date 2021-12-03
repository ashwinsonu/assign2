package com.example.assign2


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {


    var clickCountMap = mutableMapOf<String, Int>()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clickCountDisplayView = findViewById<TextView>(R.id.clickCountView)
        val clickRed = findViewById<TextView>(R.id.clickButton2)
        val userNameTextInputView = findViewById<TextInputLayout>(R.id.nameText)


        clickRed.setOnClickListener {
            val userName = userNameTextInputView.editText?.text?.toString()
            val maskedUserName =
                if (userName.isNullOrEmpty()) "Somebody"
                else userName
            val oldClickCount = clickCountMap[maskedUserName]?: 0
            val newClickCount = oldClickCount + 1

            clickCountMap[maskedUserName]= newClickCount
            clickCountDisplayView.text = "$maskedUserName clicked $newClickCount times"

        }
    }
}