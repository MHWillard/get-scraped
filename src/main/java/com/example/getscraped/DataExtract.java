package com.example.getscraped;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DataExtract {
    private Elements title;
    private String url;
    private Element firstHeading;
    private Elements headlines;
    private Elements paragraphs;

    public DataExtract(Elements title, String url, Element firstHeading, Elements headlines, Elements paragraphs) {
        this.title = title;
        this.url = url;
        this.firstHeading = firstHeading;
        this.headlines = headlines;
        this.paragraphs = paragraphs;
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

    public Elements getParagraphs() {
        return paragraphs;
    }
}
