package com.oussama.activitytp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity4 : AppCompatActivity() {
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val lv = findViewById<ListView>(R.id.list1)

        val Eng_letters = listOf("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z")

        val adapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_1, Eng_letters)

        lv.adapter = adapter1

        lv.setOnItemClickListener{ _, view, position, _ ->
            Toast.makeText(this, "You have clicked at ${Eng_letters[position]}", Toast.LENGTH_SHORT).show()
            if (Eng_letters[position] == "N") startActivity(Intent(this@MainActivity4, MainActivity5::class.java))
            when (position % 2) {
                1 -> view.setBackgroundColor(Color.RED)
                0 -> view.setBackgroundColor(Color.YELLOW)
            }
        }
    }
}