package com.example.getscraped;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Parser {
    private DataExtract data;
    public Parser() {
        //take Scraper object and add it as attribute
    }

    public void addDataExtract(DataExtract data) {
        this.data = data;
    }

    public String prepareData() {
        String textBody = "";

        for (Element title : data.getTitle()) {
            String titleText = "Title: " + title.text() + "\n";
            textBody = textBody.concat(titleText);
        }

        textBody = textBody.concat("URL: " + data.getURL() + "\n");

        textBody = textBody.concat("Heading: " + data.getFirstHeading().text() + "\n");

        for (Element headline : data.getHeadlines()) {
            String headlineText = ("Headline: " + headline.text() + "\n");
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

    public void createOutput() throws IOException {
        File file = createTextFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        String textBody = prepareData();

        writer.write(textBody);

        writer.close();
    }

    //goal 1: get the Wikipedia example and dump it as a .txt file.
    //goal 2: parse and organize a simple web page for dumping. (probably just a Wikipedia article itself.)

}
