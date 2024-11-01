package com.oussama.activitytp.game

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class MyCanvas : View {
    var paint: Paint? = null
    var check = false
    var left = false
    var right = false
    var up = false
    var down = false
    var x = 0.0
    var y = 0.0

    constructor(context: Context?) : super(context) { init() }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) { init() }

    private fun init() {
        paint = Paint()
        paint!!.color = Color.RED
        paint!!.strokeWidth = 8f
        paint!!.style = Paint.Style.FILL
    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(Color.GREEN)
        if (check == false) {
            canvas.drawCircle((this.width / 2).toFloat(),(this.height /
                    2).toFloat(), 100f,paint!!)
            x = (this.width / 2).toFloat().toDouble()// current x and y
            y = (this.height/2).toFloat().toDouble()
        } else if (left) {
            x=x-20
            canvas.drawCircle(x.toFloat(), y.toFloat(), 100f, paint!!)
        } else if (right) {
            x=x+20
            canvas.drawCircle(x.toFloat(), y.toFloat(), 100f, paint!!)
        } else if (down) {
            y=y+20
            canvas.drawCircle(x.toFloat(), y.toFloat(), 100f, paint!!)
        } else if (up) {
            y=y-20
            canvas.drawCircle(x.toFloat(), y.toFloat(), 100f, paint!!)
        }
    }

}