package com.example.calculator_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    lateinit var one : TextView
    lateinit var two : TextView
    lateinit var three : TextView
    lateinit var four : TextView
    lateinit var five : TextView
    lateinit var six : TextView
    lateinit var seven : TextView
    lateinit var eight : TextView
    lateinit var  nine : TextView
    //other
    lateinit var  clear : TextView
    lateinit var  back : ImageView
    lateinit var  add : TextView
    lateinit var  sub : TextView
    lateinit var  mul : TextView
    lateinit var  divide : TextView
    lateinit var  mod : TextView
    lateinit var  zero : TextView
    lateinit var  equals : TextView
    lateinit var  expression : TextView
    lateinit var  result : TextView
    lateinit var  point : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        one=findViewById(R.id.one)
        two=findViewById(R.id.two)
        three=findViewById(R.id.three)
        four=findViewById(R.id.four)
        five=findViewById(R.id.five)
        six=findViewById(R.id.six)
        seven=findViewById(R.id.seven)
        eight=findViewById(R.id.eight)
        nine=findViewById(R.id.nine)
        add=findViewById(R.id.add)
        mul=findViewById(R.id.mul)
        divide=findViewById(R.id.div)
        sub=findViewById(R.id.sub)
        back=findViewById(R.id.back)
        mod=findViewById(R.id.mod)
        clear=findViewById(R.id.Clear)
        result=findViewById(R.id.result)
        expression=findViewById(R.id.expression)
        point=findViewById(R.id.point)
        zero=findViewById(R.id.zero)
        equals=findViewById(R.id.equals)

        one.setOnClickListener()
        {
            appendtext("1",true)
        }
        two.setOnClickListener()
        {
            appendtext("2",true)
        }
        three.setOnClickListener()
        {
            appendtext("3",true)
        }
        four.setOnClickListener()
        {
            appendtext("4",true)
        }
        five.setOnClickListener()
        {
            appendtext("5",true)
        }
        six.setOnClickListener()
        {
            appendtext("6",true)
        }
        seven.setOnClickListener()
        {
            appendtext("7",true)
        }
        eight.setOnClickListener()
        {
            appendtext("8",true)
        }
        nine.setOnClickListener()
        {
            appendtext("9",true)
        }
        zero.setOnClickListener()
        {
            appendtext("0",true)
        }
        point.setOnClickListener()
        {
            appendtext(".",true)
        }
        add.setOnClickListener()
        {
            appendtext("+",false)
        }
        sub.setOnClickListener()
        {
            appendtext("-",false)
        }
        mul.setOnClickListener()
        {
            appendtext("*",false)
        }
        divide.setOnClickListener()
        {
            appendtext("/",false)
        }
        clear.setOnClickListener()
        {
            expression.text=""
        }
        back.setOnClickListener()
        {
            result.text=" "
            if(expression.text.isNotEmpty())
            {expression.text=expression.text.substring(0,expression.text.length-1) }
        }
        equals.setOnClickListener()
        {
           try {
            val expr=ExpressionBuilder(expression.text.toString()).build()
               val answer = expr.evaluate()
               result.text=answer.toString()
           }
           catch (e:Exception)
           {
            result.text=e.message
           }
        }
    }

    private fun appendtext(value :String,tobecleared :Boolean) {
        if (result.text !="")
        {
        expression.text=" "
        }
        if(tobecleared)
        {
            result.text=""
            expression.append(value)
        }
        else
        {
            expression.append(result.text)
            expression.append(value)
            result.text=""

        }

    }
}