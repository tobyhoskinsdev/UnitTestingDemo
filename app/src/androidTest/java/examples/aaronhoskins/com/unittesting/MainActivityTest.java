package examples.aaronhoskins.com.unittesting;


;
import android.support.test.runner.AndroidJUnitRunner;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.rule.ActivityTestRule;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);


    @Test
    public void performInputActionToOutput() {
        onView(withId(R.id.etInput))
                .perform(typeText("Hello"), closeSoftKeyboard());
        onView(withId(R.id.btnAction)).perform(click());
        onView(withId(R.id.tvOutput)).check(matches(withText("Hello")));
    }
}
