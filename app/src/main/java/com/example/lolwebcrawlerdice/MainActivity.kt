package com.example.lolwebcrawlerdice

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import org.jsoup.Jsoup
import java.util.*

lateinit var championPortrait: ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.rollButton)
        rollButton.setOnClickListener {
            rollDice()
        }

        championPortrait = findViewById(R.id.championPortrait)
    }

    private fun rollDice() {
        val randomInt = Random().nextInt(6)
        val drawableResource = when (randomInt){
            1 -> R.drawable.garen
            2 -> R.drawable.akali
            3 -> R.drawable.azir
            4 -> R.drawable.kayn
            5 -> R.drawable.viktor
            else -> R.drawable.kindred
        }
        championPortrait.setImageResource(drawableResource)
    }
}