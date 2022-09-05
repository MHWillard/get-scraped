package com.example.getscraped;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Scraper {
    private Document doc;
    private Elements newsHeadlines;

    public Scraper() {
    }

    public Document getDocument() {
        return doc;
    }

    public Elements getHeadlines() {
        return newsHeadlines;
    }

    public void connectDocument(String url) throws IOException {
        doc = Jsoup.connect(url).get();
        log(doc.title());
    }

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

    public void outputElements() {}

    //access web page from URL
    //scrape the data
    //package data as needed into HTML object for Parser to work with
    //organize and then dump as .txt. file
}
