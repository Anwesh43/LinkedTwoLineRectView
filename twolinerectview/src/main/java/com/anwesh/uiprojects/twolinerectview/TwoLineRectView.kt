package com.anwesh.uiprojects.twolinerectview

/**
 * Created by anweshmishra on 13/07/20.
 */

import android.view.View
import android.view.MotionEvent
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.Color
import android.graphics.Canvas
import android.content.Context
import android.app.Activity

val colors : Array<String> = arrayOf("#4CAF50", "#F44336", "#03A9F4", "#3F51B5", "#FF9800")
val parts : Int = 3
val scGap : Float = 0.02f / 3
val widthFactor : Float = 3.4f
val strokeFactor : Int = 90
val backColor : Int = Color.parseColor("#BDBDBD")
val delay : Long = 20

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()

fun Canvas.drawTwoLineRect(scale : Float, w : Float, h : Float, paint : Paint) {
    val sf : Float = scale.sinify()
    val wBar : Float = w / widthFactor
    for (j in 0..1) {
        val sfj : Float = sf.divideScale(j, 3)
        drawLine(-wBar / 2, 0f, wBar / 2, h * sfj, paint)
    }
    drawRect(RectF(-wBar, 0f, wBar, h * sf.divideScale(2, parts)), paint)
}

fun Canvas.drawTLRNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    paint.color = Color.parseColor(colors[i])
    paint.strokeCap = Paint.Cap.ROUND
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    save()
    translate(w / 2, 0f)
    drawTwoLineRect(scale, w, h, paint)
    restore()
}