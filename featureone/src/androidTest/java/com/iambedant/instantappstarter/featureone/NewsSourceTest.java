package com.iambedant.instantappstarter.featureone;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.iambedant.instantappstarter.ui.newsSources.NewsSourceActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by @iamBedant on 04/09/17.
 */


@RunWith(AndroidJUnit4.class)
public class NewsSourceTest {

    @Rule
    public ActivityTestRule<NewsSourceActivity> activityTestRule = new ActivityTestRule<>(NewsSourceActivity.class);

    @Test
    public void testNewsSourceApiResult(){

    }


}
