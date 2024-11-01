package com.oussama.activitytp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.oussama.activitytp.game.BallMove

class MainActivity5 : AppCompatActivity() {

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuAdd -> {
                Toast.makeText(this, "Option Ajouter sélectionnée", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.menuSave -> {
                Toast.makeText(this, "Option Save sélection", Toast.LENGTH_SHORT).show()
                    return true
            }
            R.id.menuDelete -> {
                val item = findViewById<EditText>(R.id.edittext)
                item.text.clear()
                return true
            }
            R.id.menuHelp -> {
                startActivity(Intent(this@MainActivity5, BallMove::class.java))
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main5)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btn = findViewById<Button>(R.id.button)
        val supprimer = findViewById<Button>(R.id.clear)
        val item = findViewById<EditText>(R.id.edittext)
        val lt = findViewById<ListView>(R.id.list1)
        val arrayl = mutableListOf<String>()
        var position1 :Int? = null

        btn.setOnClickListener {
            if (item.toString().isNullOrEmpty()){
                Toast.makeText(this, "the Item is not Valid", Toast.LENGTH_LONG).show()
                item.text.clear()
                return@setOnClickListener
            }
            arrayl.add(item.text.toString())
            val adapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayl)

            lt.adapter = adapter1
            item.text.clear()
        }
        supprimer.setOnClickListener {
            arrayl.clear()
            val adapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayl)
            lt.adapter = adapter1
        }

        lt.setOnItemClickListener{ _, view, position, _ ->
            position1 =position
            item.setText(arrayl[position])
        }
        if (position1 != null) Edit(this, btn, item, position1!!, arrayl, lt)

    }


}

//fun ref(context, arrayl: List<String>, lt: ListView){
//    val adapter1 = ArrayAdapter(context, android.R.layout.simple_list_item_1, arrayl)
//    lt.adapter = adapter1
//}

fun Edit(context:MainActivity5, btn: Button, item:EditText, position: Int, arrayl: MutableList<String>, listView: ListView){
    var again = false
    while (!again) {
        btn.setOnClickListener {
            if (item.toString().isNullOrEmpty()) {
                Toast.makeText(context, "the Item is not Valid", Toast.LENGTH_LONG).show()
                item.setText(arrayl[position])
                return@setOnClickListener
            }
            arrayl.set(position, item.text.toString())
            val adapter1 = ArrayAdapter(context, android.R.layout.simple_list_item_1, arrayl)

            listView.adapter = adapter1
            item.text.clear()
            again = true
        }
    }
}