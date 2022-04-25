package com.example.myapplication07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.myapplication07.views.ULFace

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val faceview=findViewById<ULFace>(R.id.cara)
        faceview.setClickListener { v:View->
            val face=v as ULFace
            face.Bocaheight+=50
        }
    }
}