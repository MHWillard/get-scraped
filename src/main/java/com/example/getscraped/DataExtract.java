package com.example.getscraped;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DataExtract {
    private Elements title;
    private Element url;
    private Elements firstHeading;
    private Elements headlines;

    public DataExtract(Elements title, Element url, Elements firstHeading, Elements headlines) {
        this.title = title;
        this.url = url;
        this.firstHeading = firstHeading;
        this.headlines = headlines;
    }

    public Element getURL() {
        return url;
    }

    public Elements getFirstHeading() {
        return firstHeading;
    }

    public Elements getTitle() {
        return title;
    }

    public Elements getHeadlines() {
        return headlines;
    }
}
