package com.example.myapplication07

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import java.io.Serializable

data class Credenciales (val username : String, val password: String) : Serializable

class LoginActivity: AppCompatActivity() {
    private var ButIngresar : Button?=null
    private var ButRegistrar : Button? =null
    private var meteUsuarioCorreo : EditText?=null
    private var meteUsuarioPass : EditText? =null
    private var meteMensaje : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        ButIngresar=findViewById(R.id.buttIngresar)
        ButRegistrar=findViewById(R.id.buttRegistrar)
        meteUsuarioCorreo=findViewById(R.id.eteUsuarioCorreo)
        meteUsuarioPass=findViewById(R.id.eteUsuarioPass)
        meteMensaje=findViewById(R.id.tvMensaje)

        //<Controller>      <View>
        //LoginActivity

        ButIngresar!!.setOnClickListener{ v : View->
            Log.i("LoginActivity","Hizoo click gaa")
            val correo: String=meteUsuarioCorreo!!.text.toString()
            val password: String = meteUsuarioPass!!.text.toString()

            if(correo=="pieroct@ulima.com" && password=="123"){
                //meteMensaje!!.text="Login correcto"
                //Configurar el intend
                val intent : Intent = Intent()
                intent.setClass(this,MainActivity::class.java)

                //Pasar parametro
                val credenciales =Credenciales(correo, password)
                val data =Bundle()
                data.putString("USERNAME", correo)
                data.putSerializable("Data_CREDENCIALES",credenciales)
                intent.putExtras(data)

                //Lanzar el intent
                startActivity(intent)
            }else{
                meteMensaje!!.text="Login incorrecto"
            }
        }

        val resultlauncher= registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {result ->
            //Codigo a ejecutarse al regresar al activity
            val intentRespuesta = result.data
            val username: String =intentRespuesta!!.getStringExtra(
                "USERNAME_REGISTRADO"
            )!!
            meteUsuarioCorreo!!.setText(username)
        }

        ButRegistrar!!.setOnClickListener { v: View ->
            val intent = Intent()
            intent.setClass(this, RegistroActivity::class.java)
            resultlauncher.launch(intent)
        }
    }

    override fun onStart() {
        super.onStart()
    }
}