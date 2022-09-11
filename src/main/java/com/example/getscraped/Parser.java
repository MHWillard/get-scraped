package com.example.getscraped;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Parser {
    //private HTMLData data;
    private Elements toParse;

    private DataExtract data;
    public Parser() {
        //take Scraper object and add it as attribute
    }

    public void addData(Elements elements) {toParse = elements;}

    public void addDataExtract(DataExtract data) {
        data = data;
    }

    /*
    *     private Elements title;
    private String url;
    private Element firstHeading;
    private Elements headlines;
    * */

    //public void parseData() {}
    //From Scraper doc object, get the elements you need by tag.

    public String prepareData() {
        String textBody = "";

        for (Element mainTitle : data.getTitle()) {
            String titleText = "Title: " + mainTitle.attr("title"+ "\n");
            textBody = textBody.concat(titleText);
        }

        textBody.concat("URL: " + data.getURL() + "\n");

        String firstHeadingText = "First Heading: " + data.getFirstHeading().attr("firstHeading"+ "\n");
        textBody = textBody.concat(firstHeadingText);

        for (Element headline : data.getHeadlines()) {
            String headlineText = "Headline: " + headline.attr("mw-headline"+ "\n");
            textBody = textBody.concat(headlineText);
        }

        return textBody;
    }
    //Iterate through elements and prepare a text block for writing in a good format.

    //public void writeFile() {}
    //Set up output.txt and write final text file to directory.
    //use TextBody returned

    public File createTextFile() {
        return new File("output.txt");
    }

    public void dumpHeadlines() throws IOException {
        //log headline and link to that article
        File newTextFile = createTextFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(newTextFile));

        for (Element headline : toParse) {
            String title = "Title: " + headline.attr("title");
            String url = "URL: " + headline.absUrl("href");

            writer.write(title + "\n" + url + "\n\n");
        }
        writer.close();
    }


    //goal 1: get the Wikipedia example and dump it as a .txt file.
    //goal 2: parse and organize a simple web page for dumping. (probably just a Wikipedia article itself.)

}
