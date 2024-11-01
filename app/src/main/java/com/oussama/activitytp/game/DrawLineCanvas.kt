package com.oussama.activitytp.game

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.os.Bundle
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DrawLineCanvas : View {
    private lateinit var c: Canvas
    private lateinit var pLine: Paint
    private lateinit var pBg: Paint
    private lateinit var touchPath: Path
    private lateinit var b: Bitmap
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        pBg = Paint()
        pBg!!.setColor(Color.WHITE)
        pLine = Paint()
        pLine!!.setColor(Color.GREEN)
        pLine!!.isAntiAlias = true
        pLine!!.style = Paint.Style.STROKE
        pLine!!.strokeWidth = 12F
        touchPath = Path()
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
            super(context, attrs, defStyleAttr)
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        b = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        c = Canvas(b)
    }
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val touchX: Float = event!!.x
        val touchY: Float = event!!.y
        when (event!!.action) {
            MotionEvent.ACTION_DOWN -> {
                touchPath!!.moveTo(touchX, touchY)
            }
            MotionEvent.ACTION_MOVE -> {
                touchPath!!.lineTo(touchX, touchY)
            }
            MotionEvent.ACTION_UP -> {
                touchPath!!.lineTo(touchX, touchY)
                c!!.drawPath(touchPath, pLine)
                touchPath = Path()
            }
            else -> {
                return false
            }
        }
        invalidate()
        return true
    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas!!.drawBitmap(b, 0F, 0F, pBg)
        canvas!!.drawPath(touchPath, pLine)
    }
}