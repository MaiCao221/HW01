package com.example.hw01

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        //判斷Intent 不為空，檢查是否有帶入資料
        intent?.extras?.let {

            val name = it.getString("name")
            val viewname = findViewById<TextView>(R.id.name)

            val number = it.getString("number")
            val viewnumber = findViewById<TextView>(R.id.number)

            viewname.text = "姓名: $name"
            viewnumber.text = "座號: $number"


            val btn = findViewById<Button>(R.id.btn)
            btn.setOnClickListener {

                val newintent = Intent(this, MainActivity::class.java)

                val editmath = findViewById<EditText>(R.id.editmath)
                newintent.putExtra("math", editmath.text.toString())

                val editeng = findViewById<EditText>(R.id.editeng)
                newintent.putExtra("eng", editeng.text.toString())

                newintent.putExtra("name", viewname.text.toString())
                newintent.putExtra("number", viewnumber.text.toString())

                setResult(AppCompatActivity.RESULT_OK, newintent.putExtras(newintent))
                finish()

            }

        }

    }
}