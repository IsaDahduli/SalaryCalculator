package com.isa.salarycalculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity()
{

    private var method1Button: Button? = null
    private var method2Button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        method1Button = findViewById<View>(R.id.button_method1) as Button
        method2Button = findViewById<View>(R.id.button_method2) as Button
    }

    fun goToMethod1(view: View?) {
        method1Button!!.setOnClickListener {
            val i = Intent(this@MainActivity, Method1Activity::class.java)
            startActivity(i)
        }
    }

    fun goToMethod2(view: View?) {
        method2Button!!.setOnClickListener {
            val i: Intent = Intent(this@MainActivity, Method2Activity::class.java)
            startActivity(i)
        }
    }


}