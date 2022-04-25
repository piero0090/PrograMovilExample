package com.example.myapplication07

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity: AppCompatActivity() {
    private var ButIngresar : Button?=null
    private var meteUsuarioCorreo : EditText?=null
    private var meteUsuarioPass : EditText? =null
    private var meteMensaje : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        ButIngresar=findViewById(R.id.buttIngresar)
        meteUsuarioCorreo=findViewById(R.id.eteUsuarioCorreo)
        meteUsuarioPass=findViewById(R.id.eteUsuarioPass)
        meteMensaje=findViewById(R.id.tvMensaje)

        ButIngresar!!.setOnClickListener{ v : View->
            Log.i("LoginActivity","Hizoo click gaa")
            val correo: String=meteUsuarioCorreo!!.text.toString()
            val password: String = meteUsuarioPass!!.text.toString()

            if(correo=="pieroct@ulima.com" && password=="123"){
                meteMensaje!!.text="Login correcto"
            }else{
                meteMensaje!!.text="Login incorrecto"
            }
        }
    }
}