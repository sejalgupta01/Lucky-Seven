package com.example.diceroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val belowButton: Button = findViewById(R.id.below7_button)
        belowButton.setOnClickListener {
            val diceImage1: ImageView = findViewById(R.id.dice_image1)
            val diceImage2: ImageView = findViewById(R.id.dice_image2)
            val numberOnDice1 = rollDice()
            val numberOnDice2 = rollDice()
            diceImage1.setImageResource(randomImage(numberOnDice1))
            diceImage2.setImageResource(randomImage(numberOnDice2))
            val sumOfDie = numberOnDice1 + numberOnDice2
            compareOutcome(sumOfDie, ::lessThan7)
            }
        val aboveButton: Button = findViewById(R.id.above7_button)
        aboveButton.setOnClickListener {
            val diceImage1: ImageView = findViewById(R.id.dice_image1)
            val diceImage2: ImageView = findViewById(R.id.dice_image2)
            val numberOnDice1 = rollDice()
            val numberOnDice2 = rollDice()
            diceImage1.setImageResource(randomImage(numberOnDice1))
            diceImage2.setImageResource(randomImage(numberOnDice2))
            val sumOfDie = numberOnDice1 + numberOnDice2
            compareOutcome(sumOfDie, ::moreThan7)
            }
        val luckyButton: Button = findViewById(R.id.lucky7_button)
        luckyButton.setOnClickListener {
            val diceImage1: ImageView = findViewById(R.id.dice_image1)
            val diceImage2: ImageView = findViewById(R.id.dice_image2)
            val numberOnDice1 = rollDice()
            val numberOnDice2 = rollDice()
            diceImage1.setImageResource(randomImage(numberOnDice1))
            diceImage2.setImageResource(randomImage(numberOnDice2))
            val sumOfDie = numberOnDice1 + numberOnDice2
            compareOutcome(sumOfDie, ::exactly7)
            }
        }
    private fun lessThan7(start: Int) = start < 7
    private fun moreThan7(start: Int) = start > 7
    private fun exactly7(start: Int) = start == 7
    private fun compareOutcome(sumOfDie: Int, operation: (Int) -> Boolean){
        if (operation(sumOfDie)){
            Toast.makeText(
                this, "You Won! Congratulations!",
                Toast.LENGTH_SHORT
            ).show()
        }
        else{
            Toast.makeText(
                this, "Hard Luck! Try Again!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
    private fun rollDice(): Int {
        return (1..6).random()
    }
    private fun randomImage(numberOnDice: Int): Int{
        return when(numberOnDice) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}
