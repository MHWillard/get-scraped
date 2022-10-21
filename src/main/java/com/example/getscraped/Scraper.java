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

        Elements article = doc.select("div#mw-content-text > div:first-of-type > p, span.mw-headline, div#mw-content-text.mw-body-content.mw-content-ltr > div:first-of-type > ul").not("span#Notes, span#References, span#Bibliography");
        //run .not() to kill the span.mew-headline that equals certain text

        Elements notes = doc.select("span#Notes, div.reflist.reflist-lower-alpha span.reference-text");
        Elements references = doc.select("span#References, div.reflist > div.mw-references-columns > ol > li > span.reference-text");
        Elements biblio = doc.select("span#Bibliography, div.refbegin.refbegin-hanging-indents.refbegin-columns.references-column-width > ul > li > cite");

        //these headers have ids: notes, references, Bibliography

        //scrape div.reflist lis into their own ArrayLists

        //div.reflist span.reference-text = notes
        //div.reflist-lower-alpha span.reference-text = references
        //cite = bibliography
        //these can go in arraylists or whatever, then get put in at the end of the article

        this.data = new DataExtract(title, url, firstHeading, article, notes, references, biblio);
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
