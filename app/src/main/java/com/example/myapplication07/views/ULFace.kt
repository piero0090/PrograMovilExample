package com.example.myapplication07.views

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.example.myapplication07.R

class ULFace : View{
    private var mpaint: Paint = Paint()
    private var msize:Float = 0f
    private var mwidth:Float = 0f
    private var mheight:Float = 0f
    private var mcolorface:Int = Color.YELLOW

    private lateinit var mListener :(v:View) ->Unit
    public var Bocaheight:Float =0f

  /*  constructor(context: Context):super(context){
        //crear una instancia pero solo desde codigo
    }*/

    constructor(context: Context,attrs:AttributeSet):super(context,attrs){
        //crear una instancia a partir de un xml
        val a : TypedArray=context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.ULFace,0,0
        )
        mcolorface=a.getColor(R.styleable.ULFace_colorCara, Color.YELLOW)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        mwidth=View.MeasureSpec.getSize(widthMeasureSpec).toFloat()
        mheight=View.MeasureSpec.getSize(heightMeasureSpec).toFloat()

        msize= Math.min(mwidth,mheight)

        setMeasuredDimension(mwidth.toInt(),mheight.toInt())
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawFace(canvas!!)
        drawOjos(canvas!!)
        drawBoca(canvas!!)
    }

    private fun drawFace(canvas: Canvas){
        mpaint.color=mcolorface
        mpaint.style=Paint.Style.FILL
        canvas.drawCircle(mwidth/2f, mheight/2f, msize/2, mpaint)
    }

    private fun drawOjos(canvas: Canvas){
        mpaint.color=Color.BLACK
        mpaint.style=Paint.Style.FILL

        val eyewidth=msize/6f
        canvas.drawCircle(mwidth/2f-msize/4f, mheight/2f-msize/4f, eyewidth/2f, mpaint)
        canvas.drawCircle(mwidth/2f+ msize/4f, mheight/2f-msize/4f, eyewidth/2f, mpaint)
    }

    private fun drawBoca(canvas: Canvas){
        mpaint.color=Color.BLACK
        mpaint.style=Paint.Style.FILL

        val bocawidth=msize/2f
        Bocaheight=msize/8f
        val rect=RectF(mwidth/2f-bocawidth/2f, mheight/2f+msize/6f, mwidth/2f+bocawidth/2f,mheight/2f+msize/6f+Bocaheight)
        canvas.drawOval(rect,mpaint)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        mListener(this)
        invalidate()
        return super.onTouchEvent(event)
    }

    fun setClickListener(listener:(v:View)->Unit){
        mListener =listener
    }

}