package xinyuz0416.android.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.*
import android.util.*
import android.view.*
import android.widget.*
import androidx.activity.*
import xinyuz0416.android.geoquiz.databinding.ActivityMainBinding

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    //    viewBinding
    private lateinit var binding: ActivityMainBinding
    //    property delegate
    private val quizViewModel: QuizViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"onCreate(Bundle?) called")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG,"Got a QuizViewModel: $quizViewModel")

        updateQuestion()

//        set button actions
        binding.trueButton.setOnClickListener {view: View ->
            checkAnswer(true)
        }
        binding.falseButton.setOnClickListener { view: View, ->
            checkAnswer(false)
        }
        binding.nextButton.setOnClickListener {
            quizViewModel.moveToNext()
            updateQuestion()
        }
        binding.prevButton.setOnClickListener {
            quizViewModel.moveToPrev()
            updateQuestion()
        }

        binding.questionTextView.setOnClickListener {
            quizViewModel.moveToNext()
            updateQuestion()
        }

    }




    private fun updateQuestion(){
        val questionResId = quizViewModel.currentQuestionText
        binding.questionTextView.setText(questionResId)
    }

    private fun checkAnswer(userAnswer: Boolean){
        val correctAnswer = quizViewModel.currentQuestionAnswer
        val messageResId = if(userAnswer == correctAnswer) R.string.correct_toast else R.string.incorrect_toast
        Toast.makeText(this,messageResId, Toast.LENGTH_SHORT).show()

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }

    override fun onPause(){
        super.onPause()
        Log.d(TAG, "onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }
}