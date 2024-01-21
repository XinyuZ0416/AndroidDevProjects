package xinyuz0416.android.geoquiz

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.*
import android.util.*
import android.view.*
import android.widget.*
import androidx.activity.*
import androidx.activity.result.contract.ActivityResultContracts
import xinyuz0416.android.geoquiz.databinding.ActivityMainBinding

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //    property delegate
    private val quizViewModel: QuizViewModel by viewModels()
    //    register MainActivity for an ActivityResult to hear back from CheatActivity to know if user cheated
    private val cheatLauncher = registerForActivityResult(
                                    ActivityResultContracts.StartActivityForResult()
                                ){result-> //handle the result
                                    if(result.resultCode == Activity.RESULT_OK){
                                        quizViewModel.isCheater = true
                                    }
                                }

    //    —————————————————————————————— onCreate —————————————————————————————————————
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"onCreate(Bundle?) called")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG,"Got a QuizViewModel: $quizViewModel")

        updateQuestion()


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
        binding.cheatButton.setOnClickListener {
            // Start CheatActivity
            val answerIsTrue = quizViewModel.currentQuestionAnswer //get the current answer
            val intent = CheatActivity.newIntent(this@MainActivity,answerIsTrue) //create an intent while passing in current answer
            cheatLauncher.launch(intent) //start activity for result
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

        val messageResId = when{
            quizViewModel.isCheater -> R.string.judgment_toast
            userAnswer == correctAnswer -> R.string.correct_toast
            else -> R.string.incorrect_toast
        }
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