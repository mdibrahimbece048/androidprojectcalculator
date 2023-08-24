package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.EditText
import org.mozilla.javascript.Script
import java.lang.StringBuilder
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class MainActivity : AppCompatActivity() {

    lateinit var button1: android.widget.Button
    lateinit var button2: android.widget.Button
    lateinit var button3: android.widget.Button
    lateinit var button4: android.widget.Button
    lateinit var button5: android.widget.Button
    lateinit var button6: android.widget.Button
    lateinit var button7: android.widget.Button
    lateinit var button8: android.widget.Button
    lateinit var button9: android.widget.Button
    lateinit var button0: android.widget.Button
    lateinit var button00: android.widget.Button
    lateinit var buttonPercent: android.widget.Button
    lateinit var buttonClear: android.widget.Button
    lateinit var buttonDot: android.widget.Button
    lateinit var buttonsol: android.widget.Button
    lateinit var buttonAdd: android.widget.Button
    lateinit var buttonSubtraction: android.widget.Button
    lateinit var buttonMul: android.widget.Button
    lateinit var buttonDivide: android.widget.Button
    lateinit var buttonBackspace: android.widget.Button

    lateinit var inputText:EditText
    lateinit var resultText:EditText
    var check=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()



        button0=findViewById(R.id._0Button)
        button1=findViewById(R.id._1Button)
        button2=findViewById(R.id._2Button)
        button3=findViewById(R.id._3Button)
        button4=findViewById(R.id._4Button)
        button5=findViewById(R.id._5Button)
        button6=findViewById(R.id._6Button)
        button7=findViewById(R.id._7Button)
        button8=findViewById(R.id._8Button)
        button9=findViewById(R.id._9Button)
        buttonClear=findViewById(R.id.cButton)
        button00=findViewById(R.id._00Button)
        buttonPercent=findViewById(R.id.ButtonPercent)
        buttonDot=findViewById(R.id._dotButton)
        buttonsol=findViewById(R.id._ButtonSol)
        buttonAdd=findViewById(R.id._ButtonAdd)
        buttonSubtraction=findViewById(R.id.ButtonSubtraction)
        buttonMul=findViewById(R.id._ButtonMul)
        buttonDivide=findViewById(R.id.division)
        buttonBackspace=findViewById(R.id.clearButton)
        inputText=findViewById(R.id.inputNumber)
        resultText=findViewById(R.id.result)

        inputText.movementMethod=ScrollingMovementMethod()
        inputText.setActivated(true)
        inputText.setPressed(true)

        var text:String

        button1.setOnClickListener {
            text=inputText.text.toString()+"1"// concatenate 1 with textNumber or with editText
            inputText.setText(text)// Adding the new text into editText
            result(text)
        }
        button2.setOnClickListener {
            text=inputText.text.toString()+"2"// concatenate 1 with textNumber or with editText
            inputText.setText(text)// Adding the new text into editText
            result(text)
        }
        button3.setOnClickListener {
            text=inputText.text.toString()+"3"// concatenate 1 with textNumber or with editText
            inputText.setText(text)// Adding the new text into editText
            result(text)
        }
        button4.setOnClickListener {
            text=inputText.text.toString()+"4"// concatenate 1 with textNumber or with editText
            inputText.setText(text)// Adding the new text into editText
            result(text)
        }
        button5.setOnClickListener {
            text=inputText.text.toString()+"5"// concatenate 1 with textNumber or with editText
            inputText.setText(text)// Adding the new text into editText
            result(text)
        }
        button6.setOnClickListener {
            text=inputText.text.toString()+"6"// concatenate 1 with textNumber or with editText
            inputText.setText(text)// Adding the new text into editText
            result(text)
        }
        button7.setOnClickListener {
            text=inputText.text.toString()+"7"// concatenate 1 with textNumber or with editText
            inputText.setText(text)// Adding the new text into editText
            result(text)
        }
        button8.setOnClickListener {
            text=inputText.text.toString()+"8"// concatenate 1 with textNumber or with editText
            inputText.setText(text)// Adding the new text into editText
            result(text)
        }
        button9.setOnClickListener {
            text=inputText.text.toString()+"9"// concatenate 1 with textNumber or with editText
            inputText.setText(text)// Adding the new text into editText
            result(text)
        }

        button0.setOnClickListener {
            text=inputText.text.toString()+"0"// concatenate 1 with textNumber or with editText
            inputText.setText(text)// Adding the new text into editText
            result(text)
        }
        buttonDot.setOnClickListener {
            text=inputText.text.toString()+"."// concatenate 1 with textNumber or with editText
            inputText.setText(text)// Adding the new text into editText
            result(text)
        }
        button00.setOnClickListener {
            text=inputText.text.toString()+"0"// concatenate 1 with textNumber or with editText
            inputText.setText(text)// Adding the new text into editText
            result(text)
        }


        buttonAdd.setOnClickListener {

            text=inputText.text.toString()+"+"
            inputText.setText(text)
            check += 1
        }
        buttonSubtraction.setOnClickListener {

            text=inputText.text.toString()+"-"
            inputText.setText(text)
            check += 1
        }
        buttonMul.setOnClickListener {

            text=inputText.text.toString()+"*"
            inputText.setText(text)
            check += 1
        }
        buttonDivide.setOnClickListener {

            text=inputText.text.toString()+"/"
            inputText.setText(text)
            check += 1
        }
        buttonPercent.setOnClickListener {

            text=inputText.text.toString()+"%"
            inputText.setText(text)
            check += 1
        }

        // for equal button
        buttonsol.setOnClickListener {

            text=resultText.text.toString()
            inputText.setText(text)
            resultText.setText(null)
        }

        // for clear button

        buttonClear.setOnClickListener {
            inputText.setText("")
            resultText.setText("")
        }
            // for backspace
        buttonBackspace.setOnClickListener {

            var backSpace:String?=null
            if (inputText.text.length>0)
            {
                val stringBuilder:StringBuilder= StringBuilder(inputText.text)
                val find=inputText.text.toString()
                val find2=find.last()

                if (find2.equals('+')||find2.equals("-") || find2.equals('*')|| find2.equals('÷'))
                {
                    check = check-1
                }

                stringBuilder.deleteCharAt(inputText.text.length-1)// deleting the number
                backSpace=stringBuilder.toString()// converting the text into string
                inputText.setText(backSpace)// Adding the contents of backspace to the inputNumber

            }
        }



    }

    private fun result(text: String) {

        val engine: ScriptEngine=ScriptEngineManager().getEngineByName("rhino")

        try {

            val result:Any=engine.eval(text)
            val mainr=result.toString()
            if (check==0)

            {
                resultText.setText(null)
            }
            else{
                resultText.setText(mainr)
            }
        }
        catch (e: ScriptException)
        {
            Log.d("TAG","ERROR")
        }

    }

}