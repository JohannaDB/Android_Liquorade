package com.example.liquorade.uiTests


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.liquorade.MainActivity
import com.example.liquorade.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class RandomCocktailTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun randomCocktailTest() {
        Thread.sleep(3000)
        val appCompatImageButton = onView(
            allOf(
                withContentDescription("Open navigation drawer"),
                childAtPosition(
                    allOf(
                        withId(R.id.action_bar),
                        childAtPosition(
                            withId(R.id.action_bar_container),
                            0
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatImageButton.perform(click())
        Thread.sleep(3000)
        val navigationMenuItemView = onView(
            allOf(
                childAtPosition(
                    allOf(
                        withId(R.id.design_navigation_view),
                        childAtPosition(
                            withId(R.id.navigation_view),
                            0
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        navigationMenuItemView.perform(click())
        Thread.sleep(1000)
    }

    @Test
    fun randomCocktailRefreshTest() {
        Thread.sleep(3000)
        val appCompatImageButton = onView(
            allOf(
                withContentDescription("Open navigation drawer"),
                childAtPosition(
                    allOf(
                        withId(R.id.action_bar),
                        childAtPosition(
                            withId(R.id.action_bar_container),
                            0
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatImageButton.perform(click())
        Thread.sleep(3000)
        val navigationMenuItemView = onView(
            allOf(
                childAtPosition(
                    allOf(
                        withId(R.id.design_navigation_view),
                        childAtPosition(
                            withId(R.id.navigation_view),
                            0
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        navigationMenuItemView.perform(click())
        Thread.sleep(3000)
        val appCompatButton = onView(
            allOf(
                withId(R.id.random_cocktail_button), withText("Give me another cocktail"),
                childAtPosition(
                    allOf(
                        withId(R.id.random_cocktail_container),
                        childAtPosition(
                            withId(R.id.random_cocktail_constraint),
                            0
                        )
                    ),
                    0
                )
            )
        )
        appCompatButton.perform(ViewActions.scrollTo(), click())
        Thread.sleep(1000)
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
