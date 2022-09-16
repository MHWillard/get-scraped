package com.example.getscraped;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Scraper {
    private Document doc;
    private String url;

    private DataExtract data;

    public Scraper() {
    }

    public Document getDocument() {
        return doc;
    }

    public void connectDocument(String url) throws IOException {
        doc = Jsoup.connect(url).get();
        log(doc.title());
    }

    public void prepDataExtract() {

        Elements title = doc.select("title");
        Element url = doc.select("link.canonical"); //use supplied URL from main controller
        Elements firstHeading = doc.select("h1.firstHeading"); //firstHeading
        Elements headlines = doc.select("span.mw-headline"); //mw-headline

        this.data = new DataExtract(title, url, firstHeading, headlines);
    }
    //Get relevant elements from Wikipedia page, starting with a few.

    public DataExtract getDataExtract() {
        return data;
    }
    //maybe return this object? Pass it in to Parser to work with

    private static void log(String msg, String... vals) {
        System.out.println(String.format(msg, vals));
    }

    //access web page from URL
    //scrape the data
    //package data as needed into HTML object for Parser to work with
    //organize and then dump as .txt. file
}
