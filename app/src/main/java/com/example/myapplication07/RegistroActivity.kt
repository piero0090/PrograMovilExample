package com.example.myapplication07

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class RegistroActivity : AppCompatActivity (){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Relacionar xml con Kotlin class
        setContentView(R.layout.activity_registro)

    }
}