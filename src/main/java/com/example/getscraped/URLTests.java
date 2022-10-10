package com.example.getscraped;

//https://www.twilio.com/blog/java-junit-effective-unit-tests

public class URLTests {
    private static URL testURL = new URL();
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
        testURL.setURL(URL_1);
        if (testURL.validate()) {
            testLogger("HTTP link", success);
        } else {testLogger("HTTP link", fail);}

        testURL.setURL(URL_2);
        if (testURL.validate()) {
            testLogger("HTTPS link", success);
        } else {testLogger("HTTPS link", fail);}
    }

    private static void testInvalidURL() {
        testURL.setURL("htt://www.wikipedia.org");
        if (testURL.validate()) {
            testLogger("HTTP link", success);
        } else {testLogger("HTTP link", fail);}

        testURL.setURL("http://www.wikipedia.org");
        if (testURL.validate()) {
            testLogger("HTTP link", success);
        } else {testLogger("HTTP link", fail);}

        testURL.setURL("http://en.wikipedia.org");
        if (testURL.validate()) {
            testLogger("HTTP link", success);
        } else {testLogger("HTTP link", fail);}
    }

    private static void testLogger(String testName, String result) {
        System.out.println("Test " + testName + result);
    }

}
