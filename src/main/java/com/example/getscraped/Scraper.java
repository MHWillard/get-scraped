package com.example.getscraped;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Scraper {
    private Document doc;

    private DataExtract data;

    public Scraper() {
    }

    public Document getDocument() {
        return doc;
    }

    public void connectDocument(String url) throws IOException {
        doc = Jsoup.connect(url).get();
    }

    public void prepDataExtract() {

        Elements title = doc.select("title");
        String url = doc.location(); //use supplied URL from main controller
        Element firstHeading = doc.select("h1.firstHeading").first(); //firstHeading

        //Elements article = doc.select("div#mw-content-text > div:first-of-type > p, span.mw-headline, span#reference-text, div.mw-references-wrap > cite, table.wikitable, div#mw-parser-output > ol > li");

        Elements article = doc.select("div#mw-content-text > div:first-of-type > p");

        this.data = new DataExtract(title, url, firstHeading, article);
    }
    //Get relevant elements from Wikipedia page, starting with a few.

    public DataExtract getDataExtract() {
        return data;
    }

}
