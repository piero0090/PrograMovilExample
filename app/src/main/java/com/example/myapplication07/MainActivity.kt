package com.example.myapplication07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
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

        if (savedInstanceState==null){
            Log.i("MainActivity", "SavedInstanceState null")
        }else{
            Log.i("MainActivity", savedInstanceState?.getString("NOMBRE")!!)
        }

        val correo=intent.getStringExtra("USERNAME")
        val credenciales : Credenciales= intent.getSerializableExtra(
            "DATA_CREDENCIALES") as Credenciales
        val tviUsername=findViewById<TextView>(R.id.txtusername)
        tviUsername.text=credenciales.username
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("NOMBRE", "Piero")
    }
}