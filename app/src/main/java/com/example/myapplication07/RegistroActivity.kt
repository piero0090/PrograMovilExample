package com.example.myapplication07

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RegistroActivity : AppCompatActivity (){
    var butRegistroGuardar : Button? =null
    var eteRegistroUsername : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Relacionar xml con Kotlin class
        setContentView(R.layout.activity_registro)

        butRegistroGuardar = findViewById(R.id.btguardar)
        eteRegistroUsername = findViewById(R.id.etregistroemail)

        butRegistroGuardar!!.setOnClickListener{ v->
            val intent = Intent()
            val data =Bundle()
            data.putString(
                "USERNAME_REGISTRADO",
                eteRegistroUsername!!.text.toString())
            intent.putExtras(data)
            setResult(RESULT_OK,intent)
            finish()
        }
    }
}