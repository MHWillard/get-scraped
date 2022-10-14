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

        textBody = textBody.concat("URL: " + data.getURL() + "\n\n");

        //textBody = textBody.concat("Heading: " + data.getFirstHeading().text() + "\n");

        for (Element item : data.getArticle()) {
            //if next item = heading element: add \n\n to the paragraph
            //then if current item is a heading: maybe surround it with equals or whatever

            //perhaps. If li has parent of certain class: reflist-lower-alpha for alphabetical, reflist for numbers, then iterate accordingly?
            //if item.parent().hasClass? = reflist
            //item.parent().hasClass("reflist");

            //group

            String escape = "\n";
            String textAdd = "";
            int iterator = 0;

            if (item.hasClass("mw-headline")) {
                textAdd = ("= " + item.text() + " =" + escape);
            } else if (item.parent().hasClass("reflist")) {
                textAdd = ((iterator + 1) + ". " + item.text() + escape);
            }

            else {
                textAdd = ("" + item.text() + escape + escape);
            }

            textBody = textBody.concat(textAdd);
        }

        return textBody;
    }
    //Iterate through elements and prepare a text block for writing in a good format.

    //public void writeFile() {}
    //Set up output.txt and write final text file to directory.
    //use TextBody returned

    public File createTextFile(String name) {
        return new File(name + ".txt");
    }

    public void createOutput() throws IOException {
        File file = createTextFile(data.getTitle().text());
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        String textBody = prepareData();
        //String textBody = writeBody();

        writer.write(textBody);

        writer.close();
    }

    //goal 1: get the Wikipedia example and dump it as a .txt file.
    //goal 2: parse and organize a simple web page for dumping. (probably just a Wikipedia article itself.)

}
