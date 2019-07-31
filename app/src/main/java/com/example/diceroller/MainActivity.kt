package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    lateinit var diceImage: ImageView
    lateinit var diceImage2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        val text: TextView = findViewById(R.id.text)
        rollButton.setOnClickListener {
            var total = 0
            for(x in 0..1000){
                if(rollDice(diceImage) == rollDice(diceImage2)){
                    total++
                }

            }
            text.text= total.toString()
        }
        diceImage = findViewById(R.id.dice_image)
        diceImage2 = findViewById(R.id.dice_image2)

    }

    private fun rollDice(image: ImageView): Int {
        //val randomInt = Random().nextInt(bound:6) + 1
        val randomInt = (1..6).random()
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        image.setImageResource(drawableResource)
        return randomInt
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//    }

}
