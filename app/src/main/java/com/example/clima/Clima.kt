package com.example.clima

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Clima : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clima)
        //Soleado > 30`
        //Nublado > 10°  < 20`
        //Lluvioso < 10°

        val ciudad = intent.getStringExtra("ciudad")
        val tvCiudad = findViewById<TextView>(R.id.tvCiudad)
        val tvGrados = findViewById<TextView>(R.id.tvGrados)
        val tvClima = findViewById<TextView>(R.id.tvClima)
        val ivClima = findViewById<ImageView>(R.id.ivClima)
        val ivBandera = findViewById<ImageView>(R.id.ivBandera)
        val ivRegresar = findViewById<ImageView>(R.id.ivRegresar)

        var grados : Int = (1..35).random()
        tvGrados.text = "${grados}°"
        estadoClima(grados, tvClima, ivClima)

        if (ciudad != null) {
            definirCiudad(ciudad, ivBandera, tvCiudad)
        }

        ivRegresar.setOnClickListener {
            finish()
        }
    }

    fun estadoClima(temp:Int, txt:TextView, img:ImageView) {
        if (temp > 20){
            img.setImageResource(R.drawable.soleado)
            txt.text = "Soleado"
        }else if (temp in 10..20){
            img.setImageResource(R.drawable.nublado)
            txt.text = "Nublado"
        }else{
            img.setImageResource(R.drawable.lluvioso)
            txt.text = "Lluvioso"
        }
    }

    fun definirCiudad(ciudad:String, img:ImageView, txt:TextView){
        txt.text = ciudad
        when(ciudad){
            "Quito" -> {
                img.setImageResource(R.drawable.quito)
            }
            "Cuenca" -> {
                img.setImageResource(R.drawable.cuenca)
            }
            "Ambato" -> {
                img.setImageResource(R.drawable.ambato)
            }
            "Guayaquil" -> {
                img.setImageResource(R.drawable.guayaquil)
            }
            "Loja" -> {
                img.setImageResource(R.drawable.loja)
            }
        }
    }
}