package com.example.getscraped;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DataExtract {
    private Elements title;
    private String url;
    private Element firstHeading;
    private Elements headlines;

    public DataExtract(Elements title, String url, Element firstHeading, Elements headlines) {
        title = title;
        url = url;
        firstHeading = firstHeading;
        headlines = headlines;
    }

    public String getURL() {
        return url;
    }

    public Element getFirstHeading() {
        return firstHeading;
    }

    public Elements getTitle() {
        return title;
    }

    public Elements getHeadlines() {
        return headlines;
    }
}
