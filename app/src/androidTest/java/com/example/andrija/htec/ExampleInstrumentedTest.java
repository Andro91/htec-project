package com.example.andrija.htec;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.andrija.htec.models.ListItemModel;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.net.MalformedURLException;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.andrija.htec", appContext.getPackageName());
    }

    //Test to check if model is converting the url from json web service
    @Test
    public void url_conversion_isCorrect() throws Exception {
        ListItemModel testListItem = new ListItemModel("http://www.google.com","Title example",
                "Description example");

        assertEquals("https://www.google.com", testListItem.getImage());
    }

    //Test to check if model is validating image url
    @Test (expected=MalformedURLException.class)
    public void url_validation_isCorrect() throws MalformedURLException {

        new ListItemModel("not a proper url","Title example", "Description example");

    }
}
