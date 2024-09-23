package gutierrez.padilla.quizapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    private lateinit var backButton: Button
    private lateinit var questionText: TextView

    private val questions = listOf(
        "Python es un lenguaje de programación orientado a objetos.",
        "HTML es considerado un lenguaje de programación.",
        "Una variable en JavaScript se declara usando la palabra clave `var`.",
        "SQL es un lenguaje que se usa principalmente para diseñar interfaces gráficas de usuario (GUI).",
        "En programación, el término 'bug' se refiere a un error en el código."
    )

    private val answers = listOf(
        true,  // Pregunta 1
        false, // Pregunta 2
        true,  // Pregunta 3
        false, // Pregunta 4
        true   // Pregunta 5
    )

    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)
        backButton = findViewById(R.id.back_button)
        questionText = findViewById(R.id.question_text)

        updateQuestion()

        trueButton.setOnClickListener {
            checkAnswer(true)
        }

        falseButton.setOnClickListener {
            checkAnswer(false)
        }

        nextButton.setOnClickListener {
            if (currentIndex < questions.size - 1) {
                currentIndex++
                updateQuestion()
            }
        }

        backButton.setOnClickListener {
            if (currentIndex > 0) {
                currentIndex--
                updateQuestion()
            }
        }
    }

    private fun updateQuestion() {
        questionText.text = questions[currentIndex]
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = answers[currentIndex]
        if (userAnswer == correctAnswer) {
            Toast.makeText(this, "Correcto!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Incorrecto!", Toast.LENGTH_SHORT).show()
        }
    }
}
