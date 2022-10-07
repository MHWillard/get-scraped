package com.example.getscraped;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DataExtract {
    private Elements title;
    private String url;
    private Element firstHeading;
    private Elements article;

    public DataExtract(Elements title, String url, Element firstHeading, Elements article) {
        this.title = title;
        this.url = url;
        this.firstHeading = firstHeading;
        this.article = article;
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

    public Elements getArticle() { return article; }
}
