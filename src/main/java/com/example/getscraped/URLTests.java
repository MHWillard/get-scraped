package com.example.getscraped;

//https://www.twilio.com/blog/java-junit-effective-unit-tests

import java.util.ArrayList;

public class URLTests {
    private static URL testURL = new URL();

    private static String[] validURLs = {"http://www.wikipedia.org","https://www.wikipedia.org","https://en.wikipedia.org","https://de.wikipedia.org","https://en.wikipedia.org/wiki/Empyrean_Challenge"};
    private static String[] invalidURLs = {"htt://www.wikipedia.org","https://ww.wikipedia.org","https://www.wiki.org"};

    private static String[] pages = {"https://en.wikipedia.org/wiki/Empyrean_Challenge","https://en.wikipedia.org/wiki/Operation_Sandwedge","https://fr.wikipedia.org/wiki/Alioramus","https://zh.wikipedia.org/wiki/Wikipedia:%E5%85%B3%E4%BA%8E","https://ru.wikipedia.org/wiki/%D0%93%D1%80%D0%B0%D0%B4_%D0%BE%D0%B1%D1%80%D0%B5%D1%87%D0%B5%D0%BD%D0%BD%D1%8B%D0%B9_(%D1%80%D0%BE%D0%BC%D0%B0%D0%BD)"};


    private static final String URL_1 = "http://www.wikipedia.org";
    private static final String URL_2 = "https://www.wikipedia.org";

    private static final String success = " was successful";
    private static final String fail = " has failed";

    //this.matcher = pattern.matcher("^http[s]:\\/\\/[a-z][a-z][.].wikipedia.org");

    public static void main(String[] args) {
        //testValidURL();
        //testInvalidURL();
        testPages();
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

    private static void testPages() {
        for (String i : pages) {
        testURL.setURL(i);
        if (testURL.validate()) {
            testLogger(i, success);
        } else {testLogger(i, fail);}
    }}

    private static void testLogger(String testName, String result) {
        System.out.println("Test " + testName + result);
    }

}
