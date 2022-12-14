package com.example.getscraped;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URL {
    private String url;
    private Pattern pattern;
    private Matcher matcher;

    public URL(String url) {
        this.url = url;
        this.pattern = Pattern.compile("^(http|https)://(www|[a-zA-Z][a-zA-Z]).wikipedia.org.*$");
        this.matcher = pattern.matcher(url);
    }

    public URL() {}

    public void setURL(String url) {
        this.url = url;
        this.pattern = Pattern.compile("^(http|https)://(www|[a-zA-Z][a-zA-Z]).wikipedia.org.*$");
        this.matcher = pattern.matcher(url);
    }

    public String getURL() {
        return url;
    }

    public boolean validate() {
        //first part must contain: https://[x].wikipedia.org at start of string, X can be up to three letters, www, en, etc.

        return this.matcher.matches();
    }
}
