package com.example.getscraped;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URL {
    private String url;
    private Pattern pattern;
    private Matcher matcher;

    public URL(String url) {
        this.url = url;
        this.pattern = Pattern.compile(url);
        this.matcher = pattern.matcher("^http[s].[a-z][a-z][.].wikipedia.org");
        //https://www.tutorialspoint.com/java/java_regular_expressions.htm
    }

    public URL() {}

    public void setURL(String url) {
        this.url = url;
        this.pattern = Pattern.compile(url);
        this.matcher = pattern.matcher("^http[s].[a-z][a-z][.].wikipedia.org");
    }

    public String getURL() {
        return url;
    }

    public boolean validate() {
        //first part must comtain: https://[x].wikipedia.org at start of string, X can be up to three letters, www, en, etc.
        //url.matches(^http[s].[a-z][a-z][.].wikipedia.org)
        // url.contains("http")

        return this.matcher.matches();
    }
}
