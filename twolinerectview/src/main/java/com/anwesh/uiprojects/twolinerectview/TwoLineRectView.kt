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
