package com.oussama.activitytp.game

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.oussama.activitytp.MainActivity2
import com.oussama.activitytp.R

class BallMove : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ball_move)
        var canvas = findViewById<View>(R.id.myview) as MyCanvas
        var left = findViewById<Button>(R.id.left)
        var right = findViewById<Button>(R.id.right)
        var up = findViewById<Button>(R.id.up)
        var down = findViewById<Button>(R.id.down)
        left.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                canvas!!.check = true
                canvas!!.left = true
                canvas!!.right = false
                canvas!!.up = false
                canvas!!.down = false
                canvas!!.invalidate()
            }
        })
        right.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                canvas!!.check = true
                canvas!!.left = false
                canvas!!.right = true
                canvas!!.up = false
                canvas!!.down = false
                canvas!!.invalidate()
            }
        })
        up.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                canvas!!.check = true
                canvas!!.left = false
                canvas!!.right = false
                canvas!!.up = true
                canvas!!.down = false
                canvas!!.invalidate()
            }
        })
        down.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                canvas!!.check = true
                canvas!!.left = false
                canvas!!.right = false
                canvas!!.up = false
                canvas!!.down = true
                canvas!!.invalidate()
            }
        })
        val button1 = findViewById<Button>(R.id.next)
        button1.setOnClickListener {
            startActivity(Intent(this@BallMove, StartDrow::class.java))
        }
    }
}