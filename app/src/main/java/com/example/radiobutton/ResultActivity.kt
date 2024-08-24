package com.example.radiobutton

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    private lateinit var rezultTV: TextView
    private lateinit var resultRateTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        rezultTV = findViewById(R.id.rezultTV)
        resultRateTV = findViewById(R.id.resultRateTV)
        var result = intent.getStringExtra("result").toString().toInt()
        rezultTV.text = result.toString()
        result /= 100
        when (result) {
            0 -> resultRateTV.text = resources.getString(R.string.result_is_0)
            1 -> resultRateTV.text = resources.getString(R.string.result_is_1)
            2 -> resultRateTV.text = resources.getString(R.string.result_is_2)
            3 -> resultRateTV.text = resources.getString(R.string.result_is_3)
            4 -> resultRateTV.text = resources.getString(R.string.result_is_4)
            5 -> resultRateTV.text = resources.getString(R.string.result_is_5)
            else -> null
        }
    }
}