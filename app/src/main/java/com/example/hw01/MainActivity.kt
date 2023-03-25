

package com.example.hw01

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {

            val intent = Intent(this, MainActivity2::class.java)

            val editname = findViewById<EditText>(R.id.editName)
            intent.putExtra("name", editname.text.toString())

            val editnumber = findViewById<EditText>(R.id.editNumber)
            intent.putExtra("number", editnumber.text.toString())

            startActivityForResult(intent, 1)

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        data?.extras?.let {

            if (requestCode == 1 && resultCode == Activity.RESULT_OK)
            {

                val viewmath = findViewById<TextView>(R.id.viewmath)
                viewmath.text = "數學成績: ${it.getString("math")}"

                val vieweng = findViewById<TextView>(R.id.vieweng)
                vieweng.text = "英文成績: ${it.getString("eng")}"

                viewmath.visibility = View.VISIBLE
                vieweng.visibility = View.VISIBLE

            }

        }

    }
}