package com.example.radiobutton

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var run_victBTN: Button
    var numberOfQuestion = "0"
    var rezult = "0"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        run_victBTN = findViewById(R.id.run_victBTN)
        run_victBTN.setOnClickListener {
            val intent = Intent(this, QuestionsActivity::class.java)
            intent.putExtra("numberOfQuestion", numberOfQuestion)
            intent.putExtra("result", rezult)
            startActivity(intent)
        }
    }
}