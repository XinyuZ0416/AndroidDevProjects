package xinyuz0416.android.geoquiz

import android.app.Activity
import android.content.*
import androidx.appcompat.app.AppCompatActivity
import android.os.*
import android.util.*
import xinyuz0416.android.geoquiz.databinding.ActivityCheatBinding

private const val EXTRA_ANSWER_IS_TRUE = "xinyuz0416.android.geoquiz.answer_is_true"
private const val EXTRA_ANSWER_SHOWN = "xinyuz0416.android.geoquiz.answer_shown"

class CheatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCheatBinding
    private var answerIsTrue = false

    //    —————————————————————————————— onCreate —————————————————————————————————————
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheatBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        extract answer data from main activity
        answerIsTrue = intent.getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false)

        binding.showAnswerButton.setOnClickListener {
            val answerText = when{
                answerIsTrue -> R.string.true_button
                else -> R.string.false_button
            }

            binding.answerTextView.setText(answerText)
            setAnswerShownResult(true)
        }
    }

    companion object{
        fun newIntent(packageContext: Context, answerIsTrue: Boolean): Intent{
            return Intent(packageContext, CheatActivity::class.java)
                .apply{putExtra(EXTRA_ANSWER_IS_TRUE,answerIsTrue)}
        }
    }

    private fun setAnswerShownResult(isAnswerShown: Boolean){
        val data = Intent().apply{putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown)} //data is an Intent with info whether user cheated
        setResult(Activity.RESULT_OK, data) //send data back to MainActivity
    }

}