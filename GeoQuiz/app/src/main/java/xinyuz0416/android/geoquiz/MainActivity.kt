package xinyuz0416.android.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import xinyuz0416.android.geoquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //    use viewBinding
    private lateinit var binding: ActivityMainBinding

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true))

    private var currentIndex = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        updateQuestion()

//        set button actions
        binding.trueButton.setOnClickListener {view: View ->
            checkAnswer(true)
        }
        binding.falseButton.setOnClickListener { view: View, ->
            checkAnswer(false)
        }
        binding.nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestion()
        }

    }


    private fun updateQuestion(){
        val questionResId = questionBank[currentIndex].textResId
        binding.questionTextView.setText(questionResId)
    }

    private fun checkAnswer(userAnswer: Boolean){
        val correctAnswer = questionBank[currentIndex].answer
        val messageResId = if(userAnswer == correctAnswer) R.string.correct_toast else R.string.incorrect_toast
        Toast.makeText(this,messageResId, Toast.LENGTH_SHORT).show()

    }
}