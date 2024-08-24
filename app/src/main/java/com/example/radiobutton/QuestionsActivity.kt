package com.example.radiobutton

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuestionsActivity : AppCompatActivity() {
    private val quiz = makeQuiz()
    private lateinit var questionTitleTV: TextView
    private lateinit var questionTextTV: TextView
    private lateinit var answersTitleTV: TextView
    private lateinit var answersRG: RadioGroup
    private lateinit var answerOneRB: RadioButton
    private lateinit var answerTwoRB: RadioButton
    private lateinit var answerThreeRB: RadioButton
    private lateinit var nextQuestionBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_questions)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var numberOfQuestion = intent.getStringExtra("numberOfQuestion").toString().toInt()

        var result = intent.getStringExtra("result").toString().toInt()

        questionTitleTV = findViewById(R.id.questionTitleTV)
        questionTextTV = findViewById(R.id.questionTextTV)
        answersTitleTV = findViewById(R.id.answersTitleTV)
        answersRG = findViewById(R.id.answersRG)
        answerOneRB = findViewById(R.id.answerOneRB)
        answerTwoRB = findViewById(R.id.answerTwoRB)
        answerThreeRB = findViewById(R.id.answerThreeRB)
        nextQuestionBTN = findViewById(R.id.nextQuestionBTN)

        questionTitleTV.text =
            resources.getString(R.string.questions_title) + (numberOfQuestion+1).toString() + "."
        questionTextTV.text = quiz[numberOfQuestion][0]
        answerOneRB.text = quiz[numberOfQuestion][1]
        answerTwoRB.text = quiz[numberOfQuestion][2]
        answerThreeRB.text = quiz[numberOfQuestion][3]

        nextQuestionBTN.setOnClickListener {
            val button: Int = answersRG.checkedRadioButtonId
            if (button == -1) {
                Toast.makeText(
                    this,
                    resources.getString(R.string.error_answer_not_selected),
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }
            val rButton: RadioButton = findViewById(button)
            if (rButton.hint == quiz[numberOfQuestion][4]){
                result += 100
            }
            numberOfQuestion++
            if (numberOfQuestion < quiz.size) {
                val intent = Intent(this, QuestionsActivity::class.java)
                intent.putExtra("numberOfQuestion", numberOfQuestion.toString())
                intent.putExtra("result", result.toString())
                startActivity(intent)
            } else {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("result", result.toString())
                startActivity(intent)
            }
        }
    }
}