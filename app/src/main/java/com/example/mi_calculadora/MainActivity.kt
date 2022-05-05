package com.example.mi_calculadora

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var num1 : Double = 0.0
    private var num2 : Double = 0.0
    private var operacion: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_0.setOnClickListener{numeroPresionado("0")}
        btn_1.setOnClickListener{numeroPresionado("1")}
        btn_2.setOnClickListener{numeroPresionado("2")}
        btn_3.setOnClickListener{numeroPresionado("3")}
        btn_4.setOnClickListener{numeroPresionado("4")}
        btn_5.setOnClickListener{numeroPresionado("5")}
        btn_6.setOnClickListener{numeroPresionado("6")}
        btn_7.setOnClickListener{numeroPresionado("7")}
        btn_8.setOnClickListener{numeroPresionado("8")}
        btn_9.setOnClickListener{numeroPresionado("9")}
        btn_punto.setOnClickListener{numeroPresionado(".")}

        btn_suma.setOnClickListener{operacionPresionada(1)}
        btn_resta.setOnClickListener{operacionPresionada(2)}
        btn_multiplicacion.setOnClickListener{operacionPresionada(3)}
        btn_division.setOnClickListener{operacionPresionada(4)}

        btn_clear.setOnClickListener{borrarResultados()}
        btn_igual.setOnClickListener{igualResultados()}
    }

    private fun numeroPresionado(digito: String){
        tv_resultados.text = tv_resultados.text.toString() + digito
        if(operacion == NO_OPERACION){
            num1 = tv_resultados.text.toString().toDouble()
        }else{
            num2 = tv_resultados.text.toString().toDouble()
        }
    }

    private fun operacionPresionada(operacion: Int){
        this.operacion = operacion
        tv_resultados.text = "0"
    }

    companion object{
        const val SUMA = 1
        const val RESTA = 2
        const val MULTIPLICACION = 3
        const val DIVISION = 4
        const val NO_OPERACION = 0
    }

    private fun borrarResultados(){
        num1 = 0.0
        num2 = 0.0
        tv_resultados.text = "0"
        operacion = NO_OPERACION
    }

    private fun igualResultados(){
        var resultado = when(operacion){
            SUMA -> num1 + num2
            RESTA -> num1 - num2
            MULTIPLICACION -> num1 * num2
            DIVISION -> num1 / num2
            else -> 0
        }
        tv_resultados.text = resultado.toString()
    }
}