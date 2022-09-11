package com.example.getscraped;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Scraper {
    private Document doc;
    private Elements newsHeadlines;

    private DataExtract data;

    public Scraper() {
    }

    public Document getDocument() {
        return doc;
    }

    public Elements getNewsHeadlines() {
        return newsHeadlines;
    }

    public void connectDocument(String url) throws IOException {
        doc = Jsoup.connect(url).get();
        log(doc.title());
    }

    public void prepDataExtract() {
        Elements title = doc.getElementsByTag("title");
        String url = doc.absUrl("href");
        Element firstHeading = doc.getElementById("firstHeading");
        Elements headlines = doc.getElementsByClass("mw-headline");

        data = new DataExtract(title, url, firstHeading, headlines);
    }
    //Get relevant elements from Wikipedia page, starting with a few.

    public DataExtract getDataExtract() {
        return data;
    }
    //maybe return this object? Pass it in to Parser to work with

    public void grabHeadlines(Document doc) {
        newsHeadlines = doc.select("#mp-itn b a");
    }

    public void printHeadlines(Elements newsHeadlines) {
        //log headline and link to that article
        for (Element headline : newsHeadlines) {
            log("%s\n\t%s", headline.attr("title"), headline.absUrl("href"));
        }
    }

    private static void log(String msg, String... vals) {
        System.out.println(String.format(msg, vals));
    }

    //access web page from URL
    //scrape the data
    //package data as needed into HTML object for Parser to work with
    //organize and then dump as .txt. file
}
