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
        log(doc.title());
    }

    public void prepDataExtract() {

        Elements title = doc.select("title");
        String url = doc.location(); //use supplied URL from main controller
        Element firstHeading = doc.select("h1.firstHeading").first(); //firstHeading
        Elements headlines = doc.select("span.mw-headline"); //mw-headline
        Element content = doc.getElementById("content");
        Elements paragraphs = content.getElementsByTag("p");

        //have to get each heading and the content of the heading under it in order

        this.data = new DataExtract(title, url, firstHeading, headlines, paragraphs);
    }
    //Get relevant elements from Wikipedia page, starting with a few.

    public void prepStuff() {
        Elements stuff = doc.select("div#mw-content-text > div:first-of-type > p, span.mw-headline, div#mw-content-text > div:first-of-type > ul, div#mw-content-text > div:first-of-type > li");
        //Pull only good ul/li within content and not past bilbiopgraphy

        this.data = new DataExtract(stuff);
    }

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
