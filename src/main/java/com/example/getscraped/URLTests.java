package com.example.getscraped;

//https://www.twilio.com/blog/java-junit-effective-unit-tests

import java.util.ArrayList;

public class URLTests {
    private static URL testURL = new URL();

    private static String[] validURLs = {"http://www.wikipedia.org","https://www.wikipedia.org","https://en.wikipedia.org","https://de.wikipedia.org"};
    private static String[] invalidURLs = {"htt://www.wikipedia.org","https://ww.wikipedia.org","https://www.wiki.org"};


    private static final String URL_1 = "http://www.wikipedia.org";
    private static final String URL_2 = "https://www.wikipedia.org";
    private static final String URL_3 = "";
    private static final String URL_4 = "";

    private static final String success = " was successful";
    private static final String fail = " has failed";

    //this.matcher = pattern.matcher("^http[s]:\\/\\/[a-z][a-z][.].wikipedia.org");

    public static void main(String[] args) {
        testValidURL();
        testInvalidURL();
    }

    private static void testValidURL() {
        for (String i : validURLs) {
            testURL.setURL(i);
            if (testURL.validate()) {
                testLogger(i, success);
            } else {testLogger(i, fail);}
        }
    }

    private static void testInvalidURL() {
        for (String i : invalidURLs) {
            testURL.setURL(i);
            if (testURL.validate()) {
                testLogger(i, success);
            } else {testLogger(i, fail);}
        }
    }

    private static void testLogger(String testName, String result) {
        System.out.println("Test " + testName + result);
    }

}
