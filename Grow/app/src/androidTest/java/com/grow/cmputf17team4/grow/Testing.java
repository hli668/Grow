package com.grow.cmputf17team4.grow;


import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.contrib.PickerActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.DatePicker;

import com.grow.cmputf17team4.grow.Controllers.DataManager;
import com.grow.cmputf17team4.grow.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import com.grow.cmputf17team4.grow.Controllers.DataManager;
import com.grow.cmputf17team4.grow.Models.HabitType;
import com.grow.cmputf17team4.grow.Views.ActivityMain;
import com.grow.cmputf17team4.grow.Views.ActivityModifyEvent;
import com.grow.cmputf17team4.grow.Views.ActivityModifyHabit;

import junit.framework.Assert;

import java.util.Calendar;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class Testing {

    @Rule
    public ActivityTestRule<ActivityMain> mActivityTestRule = new ActivityTestRule<>(ActivityMain.class);
    private ActivityMain activityM = null;

    Instrumentation.ActivityMonitor monitor = InstrumentationRegistry.getInstrumentation().addMonitor(ActivityModifyHabit.class.getName(),null,false);


    @Before
    public void setUp(){

        activityM = mActivityTestRule.getActivity();
    }

    @Test
    public void testing1() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.dialog_edit_id),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.custom),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText.perform(click());

        ViewInteraction loginUser = onView(
                allOf(withId(R.id.dialog_edit_id),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.custom),
                                        0),
                                0),
                        isDisplayed()));
        loginUser.perform(typeText("fufu"), closeSoftKeyboard());

        assertNotNull(loginUser);


        ViewInteraction editText = onView(
                allOf(withId(R.id.dialog_edit_id), withText("fufu")));
        editText.check(matches(withText("fufu")));

        ViewInteraction appCompatButton = onView(
                allOf(withId(android.R.id.button1), withText("Confirm"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.buttonPanel),
                                        0),
                                3)));
        appCompatButton.perform(scrollTo(), click());

        ViewInteraction switchnavigation_event = Espresso.onView(ViewMatchers.withId(R.id.navigation_event)).perform(ViewActions.click());
        assertNotNull(switchnavigation_event);
        ViewInteraction switchnavigation_community = Espresso.onView(ViewMatchers.withId(R.id.navigation_community)).perform(ViewActions.click());
        assertNotNull(switchnavigation_community);
        ViewInteraction switchnavigation_settings = Espresso.onView(ViewMatchers.withId(R.id.navigation_settings)).perform(ViewActions.click());
        assertNotNull(switchnavigation_settings);
        ViewInteraction switchnavigation_habit = Espresso.onView(ViewMatchers.withId(R.id.navigation_habit)).perform(ViewActions.click());
        assertNotNull(switchnavigation_habit);

        Espresso.onView(ViewMatchers.withId(R.id.toolbar_btn_add_habit)).perform(ViewActions.click());

        Activity addbutton = InstrumentationRegistry.getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);

        ViewInteraction habitEditName = Espresso.onView(ViewMatchers.withId(R.id.modify_habit_edit_name))
                .perform(ViewActions.typeText("basketball"));
        assertNotNull(habitEditName);

        ViewInteraction habitEditReason = Espresso.onView(ViewMatchers.withId(R.id.modify_habit_edit_reason))
                .perform(ViewActions.typeText("Love it"));
        assertNotNull(habitEditReason);

        Espresso.onView(ViewMatchers.withId(R.id.modify_habit_edit_reason)).perform(ViewActions.closeSoftKeyboard());


        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        //System.out.println(day);
        switch (day) {
            case Calendar.SUNDAY:
                ViewInteraction dayOfWeek0 = Espresso.onView(ViewMatchers.withId(R.id.modify_habit_checkbox_0))
                        .perform(ViewActions.click());
                assertNotNull(dayOfWeek0);
                break;

            case Calendar.MONDAY:
                // Current day is Monday
                ViewInteraction dayOfWeek1 =Espresso.onView(ViewMatchers.withId(R.id.modify_habit_checkbox_1)).perform(ViewActions.click());
                assertNotNull(dayOfWeek1);
                break;


            case Calendar.TUESDAY:
                // Tuesday
                ViewInteraction dayOfWeek2 =Espresso.onView(ViewMatchers.withId(R.id.modify_habit_checkbox_2)).perform(ViewActions.click());
                assertNotNull(dayOfWeek2);
                break;

            case Calendar.WEDNESDAY:
                ViewInteraction dayOfWeek3 =Espresso.onView(ViewMatchers.withId(R.id.modify_habit_checkbox_3)).perform(ViewActions.click());
                assertNotNull(dayOfWeek3);
                break;

            case Calendar.THURSDAY:
                ViewInteraction dayOfWeek4 =Espresso.onView(ViewMatchers.withId(R.id.modify_habit_checkbox_4)).perform(ViewActions.click());
                assertNotNull(dayOfWeek4);
                break;

            case Calendar.FRIDAY:
                ViewInteraction dayOfWeek5 =Espresso.onView(ViewMatchers.withId(R.id.modify_habit_checkbox_5)).perform(ViewActions.click());
                assertNotNull(dayOfWeek5);
                break;

            case Calendar.SATURDAY:
                ViewInteraction dayOfWeek6 =Espresso.onView(ViewMatchers.withId(R.id.modify_habit_checkbox_6)).perform(ViewActions.click());
                assertNotNull(dayOfWeek6);
                break;

        }

        ViewInteraction habitBtnConfirm = onView(
                allOf(withId(R.id.modify_habti_btn_confirm), withText("Confirm")));
        habitBtnConfirm.perform(click());

        assertNotNull(habitBtnConfirm);



        onData(anything()).inAdapterView(allOf(withId(R.id.card_list_view),isDisplayed()))
                .atPosition(0).onChildView (withId(R.id.list_item_title)).check(matches(withText("basketball")));



        ViewInteraction habitListItemBtnComplete = onData(anything()).inAdapterView(allOf(withId(R.id.card_list_view),isDisplayed()))
                .atPosition(0).onChildView (withId(R.id.list_item_btn_complete)).perform(click());
        assertNotNull(habitListItemBtnComplete);

        ViewInteraction completeEventEditComment = Espresso.onView(ViewMatchers.withId(R.id.modify_event_edit_comment)).
                perform(ViewActions.typeText("tired"));
        assertNotNull(completeEventEditComment);

        Espresso.onView(ViewMatchers.withId(R.id.modify_event_edit_comment)).perform(ViewActions.closeSoftKeyboard());

        ViewInteraction confirmBtn = Espresso.onView(ViewMatchers.withId(R.id.button2)).perform(ViewActions.click());
        assertNotNull(confirmBtn);



        ViewInteraction editExistHabit = onData(anything()).inAdapterView(allOf(withId(R.id.card_list_view), isDisplayed()))
                .atPosition(0).perform(click());
        assertNotNull(editExistHabit);

        ViewInteraction habitChangeName = Espresso.onView(ViewMatchers.withId(R.id.modify_habit_edit_name))
                .perform(ViewActions.clearText(),ViewActions.typeText("zhai"));
        assertNotNull(habitChangeName);

        Espresso.onView(ViewMatchers.withId(R.id.modify_habit_edit_name)).perform(ViewActions.closeSoftKeyboard());
        ViewInteraction habitBtnConfirm1 = Espresso.onView(ViewMatchers.withId(R.id.modify_habti_btn_confirm))
                .perform(ViewActions.click());
        //assertion
        assertNotNull(habitBtnConfirm1);

        onData(anything()).inAdapterView(allOf(withId(R.id.card_list_view),isDisplayed()))
                .atPosition(0).onChildView (withId(R.id.list_item_title)).check(matches(withText("zhai")));

        ViewInteraction editExistHabit1 = onData(anything()).inAdapterView(allOf(withId(R.id.card_list_view), isDisplayed()))
                .atPosition(0).perform(click());
        assertNotNull(editExistHabit1);

        ViewInteraction habitChangeReason = Espresso.onView(ViewMatchers.withId(R.id.modify_habit_edit_reason))
                .perform(ViewActions.clearText(),ViewActions.typeText("kill him"));
        assertNotNull(habitChangeReason);
        Espresso.onView(ViewMatchers.withId(R.id.modify_habit_edit_reason)).perform(ViewActions.closeSoftKeyboard());

        ViewInteraction habitBtnConfirm2 = Espresso.onView(ViewMatchers.withId(R.id.modify_habti_btn_confirm))
                .perform(ViewActions.click());

        //assertion
        assertNotNull(habitBtnConfirm2);

        ViewInteraction editExistHabit2 = onData(anything()).inAdapterView(allOf(withId(R.id.card_list_view), isDisplayed()))
                .atPosition(0).perform(click());
        assertNotNull(editExistHabit2);

        onView(withId(R.id.modify_habit_edit_name)).check(matches(withText("zhai")));
        onView(withId(R.id.modify_habit_edit_reason)).check(matches(withText("kill him")));


        onView(withId(R.id.modify_habit_edit_date)).perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(2018, 01, 01));

        onView(withId(android.R.id.button1)).perform(click());

        onView(ViewMatchers.withId(R.id.modify_habti_btn_confirm)).perform(ViewActions.click());

        onData(anything()).inAdapterView(allOf(withId(R.id.card_list_view), isDisplayed()))
                .atPosition(0).perform(click());
        onView(withId(R.id.modify_habit_edit_date)).check(matches(withText("Monday, Jan 01")));

        onView(ViewMatchers.withId(R.id.modify_habti_btn_confirm)).perform(ViewActions.click());

        /*
        onData(anything()).inAdapterView(allOf(withId(R.id.card_list_view), isDisplayed()))
                .atPosition(0).perform(click());


        ViewInteraction deleteButton = Espresso.onView(ViewMatchers.withId(R.id.modify_habit_btn_delete)).perform(ViewActions.click());
        assertNotNull(deleteButton);*/

        ViewInteraction changeToEvent = Espresso.onView(ViewMatchers.withId(R.id.navigation_event)).perform(ViewActions.click());
        assertNotNull(changeToEvent);


        ViewInteraction editExistEvent = onData(anything()).inAdapterView(allOf(withId(R.id.card_list_view), isDisplayed()))
                .atPosition(0).perform(click());
        assertNotNull(editExistEvent);

        ViewInteraction eventEditcomment = Espresso.onView(ViewMatchers.withId(R.id.modify_event_edit_comment))
                .perform(ViewActions.clearText(),ViewActions.typeText("test"));
        assertNotNull(eventEditcomment);

        Espresso.onView(ViewMatchers.withId(R.id.modify_event_edit_comment)).perform(ViewActions.closeSoftKeyboard());

        ViewInteraction eventButtonConfirm = Espresso.onView(ViewMatchers.withId(R.id.button2))
                .perform(ViewActions.click());

        onData(anything()).inAdapterView(allOf(withId(R.id.card_list_view),isDisplayed()))
                .atPosition(0).onChildView (withId(R.id.list_item_text_subtitle)).check(matches(withText("test")));


        onData(anything()).inAdapterView(allOf(withId(R.id.card_list_view), isDisplayed())).atPosition(0).perform(click());

        ViewInteraction eventDeleteButton = Espresso.onView(ViewMatchers.withId(R.id.modify_event_btn_delete))
                .perform(ViewActions.click());
        assertNotNull(eventDeleteButton);

        ViewInteraction changeToEventAgain = Espresso.onView(ViewMatchers.withId(R.id.navigation_event)).perform(ViewActions.click());
        assertNotNull(changeToEventAgain);





        //Espresso.onView(ViewMatchers.withId(R.id.modify_event_edit_comment)).perform(ViewActions.closeSoftKeyboard());


        addbutton.finish();

    }

    @After
    public void tearDown() throws Exception {
        DataManager.clear();
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
