package com.example.mathlearn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_aprende.*

class Aprende : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aprende)

        var listaElementos = mutableListOf<String>()

        seekBar2.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                listaElementos.clear()//aquí limpia la lista
                if (p1 < 1){
                    seekBar2.setProgress(1)
                }
                if (p1 > 0){

                for (i in 0..10) {
                    val texto = "$p1 x $i = ${p1 * i}"
                    listaElementos.add(texto)//aquí añado el nuevo elemento
                    }
                }
                val adaptador = ArrayAdapter(application, android.R.layout.simple_list_item_1, listaElementos)
                listaTablas.adapter = adaptador
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

        BtnRegresar.setOnClickListener(){
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }
    }
}