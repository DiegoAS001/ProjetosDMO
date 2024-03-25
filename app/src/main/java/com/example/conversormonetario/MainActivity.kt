package com.example.conversormonetario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener{

    private val VALOR_DOLAR = 5.50 // definindo o valor do dollar

    //declaração dos objetos utilizados na tela do app
    private lateinit var entrada: EditText
    private lateinit var BotaoDollar: Button
    private lateinit var BotaoReal: Button
    private lateinit var resultado : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_main)

        findById()
        configClickListener()
    }

    //metodo para selecionar a conversao
    override fun onClick(v: View?) {
        if ( v == BotaoDollar){
            dollarConversion()
        }else if (v == BotaoReal){
            realConversion()
        }
    }

    //metodo que atraves do id vincula os dados aos objetos da classe
    private fun findById(){
        entrada = findViewById(R.id.text_valor)
        BotaoDollar = findViewById(R.id.botao_dolar)
        BotaoReal = findViewById(R.id.botao_real)
        resultado = findViewById(R.id.text_resultado)
    }

    //metodo para configurar o clique do botão
    private fun configClickListener(){
        BotaoDollar.setOnClickListener(this)
        BotaoReal.setOnClickListener(this)
    }

    //metodo para obter e converter a entrada de dados
    private fun getValue(): Double{
        return try {
            entrada.text.toString().toDouble()
        }catch (e: NumberFormatException){
            0.0
        }
    }

    // metodo para conversao de real para dolar
    private fun dollarConversion(){
        var value = getValue()
        value  = value / VALOR_DOLAR
        resultado.text = "U$ $value"
    }

    //metodo para conversao de dolar para real
    private fun realConversion(){
        var value = getValue()
        value  = value * VALOR_DOLAR
        resultado.text = "R$ $value"
    }

}