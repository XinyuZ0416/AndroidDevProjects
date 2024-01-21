package xinyuz0416.android.geoquiz

import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.*
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class CheatActivityTest {

    private lateinit var scenario: ActivityScenario<CheatActivity>
    private lateinit var scenario2: ActivityScenario<MainActivity>


    @Before
    fun setUp() {
        scenario = launch(CheatActivity::class.java)
        scenario2 = launch(MainActivity::class.java)
    }

    @After
    fun tearDown() {
        scenario.close()
        scenario2.close()
    }

    @Test
    fun showsCheatActivity(){
        onView(withId(R.id.cheat_button)).perform(click())
        onView(withId(R.id.show_answer_button)).check(matches(withText(R.string.show_answer_button)))
    }
}