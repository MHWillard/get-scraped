package com.example.getscraped;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DataExtract {
    private Elements title;
    private String url;
    private Element firstHeading;
    private Elements article;
    private Elements notes;
    private Elements references;
    private Elements biblio;

    public DataExtract(Elements title, String url, Element firstHeading, Elements article, Elements notes, Elements references, Elements biblio) {
        this.title = title;
        this.url = url;
        this.firstHeading = firstHeading;
        this.article = article;
        this.notes = notes;
        this.references = references;
        this.biblio = biblio;
    }

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

    public Elements getNotes() { return notes; }

    public Elements getReferences() { return references; }

    public Elements getBiblio() { return biblio; }
}
