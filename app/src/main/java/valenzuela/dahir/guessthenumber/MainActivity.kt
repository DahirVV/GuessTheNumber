package valenzuela.dahir.guessthenumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.math.max
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var minvalue=0
    var maxvalue=100
    var num:Int=0
    var won=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val guessing: TextView = findViewById(R.id.guessings)
        val down: Button = findViewById(R.id.down)
        val up: Button = findViewById(R.id.up)
        val generate: Button = findViewById(R.id.generate)
        val guessed: Button = findViewById(R.id.guessed)

        generate.setOnClickListener{
            num = Random.nextInt(minvalue, maxvalue)
            guessing.setText(num.toString())
            generate.visibility= View.INVISIBLE
            guessed.visibility= View.VISIBLE
        }

        up.setOnClickListener{
            minvalue=num
            if(checkingLimits()) {
                num = Random.nextInt(minvalue, maxvalue)
                guessing.text = num.toString()
            }else{
                guessing.text="No puede ser, GANASTE"
            }
        }

        down.setOnClickListener{
            maxvalue=num
            if (checkingLimits()) {
                num = Random.nextInt(minvalue, maxvalue)
                guessing.text=num.toString()
            }else{
                guessing.text="No puede ser, GANASTE"
            }
        }

        guessed.setOnClickListener{
            if(!won){
                guessing.text="Adivine tu numero, es el" + num
                guessed.text="Volver a jugar"
                won=true
            }else{
                generate.visibility=View.VISIBLE
                guessing.text="Tap on generate to start"
                guessed.visibility=View.GONE
                resetValues()
            }
        }

    }
    fun resetValues(){
        minvalue=0
        maxvalue=100
        num=0
        won=false
    }
    fun checkingLimits() : Boolean{
        return minvalue!=maxvalue
    }
}