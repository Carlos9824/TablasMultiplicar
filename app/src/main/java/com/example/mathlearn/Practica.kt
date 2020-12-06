package com.example.mathlearn

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_practica.*
import kotlin.math.log
import kotlin.random.Random

class Practica : AppCompatActivity() {
    var resultado = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practica)

        generaoperacion()

        btnComprobar.setOnClickListener(){

            val restText = etRespuesta.text.toString()
            if(!restText.equals("")){
                val respuesta = restText.toInt()

                if(resultado == respuesta) {
                    Log.d("resultado", "Correcto")
                    creardialogo()
                }else{
                    Log.d("resultado","Incorrecto")
                    creardialogoerror()
                }

            }
            generaoperacion()
        }

        btnRegresar.setOnClickListener(){
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }

    }
    fun creardialogo(){
        val miDialogo = LayoutInflater.from(this).inflate(R.layout.dialogok,null)
        val mBiulder = AlertDialog.Builder(this).setView(miDialogo)
            .setTitle("Correcto!!")
        val miDialogoOk = mBiulder.create()
        miDialogoOk.show()
    }

    fun creardialogoerror(){
        val miDialogo = LayoutInflater.from(this).inflate(R.layout.dialogoerror,null)
        val mBiulder = AlertDialog.Builder(this).setView(miDialogo)
            .setTitle("Incorrecto!!")
        val miDialogoerror = mBiulder.create()
        miDialogoerror.show()
    }




    fun generaoperacion(){
        val operador1 = Random.nextInt(1,10)
        val operador2 = Random.nextInt(1,10)

        resultado = operador1 * operador2
        tvOperacion.text = "$operador1 x $operador2 = ?"
        etRespuesta.text.clear()
    }
}