package com.example.clima

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnQuito:Button = findViewById(R.id.btnQuito)
        val btnCuenca:Button = findViewById(R.id.btnCuenca)
        val btnAmbato:Button = findViewById(R.id.btnAmbato)
        val btnGye:Button = findViewById(R.id.btnGuayaquil)
        val btnLoja:Button = findViewById(R.id.btnLoja)
        val ventanaClima = Intent(this, Clima::class.java)

        btnQuito.setOnClickListener{
            definirBoton(btnQuito, ventanaClima)
        }

        btnCuenca.setOnClickListener{
            definirBoton(btnCuenca, ventanaClima)
        }

        btnAmbato.setOnClickListener{
            definirBoton(btnAmbato, ventanaClima)
        }

        btnGye.setOnClickListener{
            definirBoton(btnGye, ventanaClima)
        }

        btnLoja.setOnClickListener{
            definirBoton(btnLoja, ventanaClima)
        }
    }

    fun definirBoton(btn:Button, vtn : Intent){
        val opcion = btn.text.toString()
        vtn.putExtra("ciudad", opcion)
        startActivity(vtn)
    }

}