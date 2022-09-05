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
    public Parser() {

    }

    public void addData(Elements elements) {toParse = elements;}

    public void parseData() {}

    public void cleanData() {}

    public void returnCleanData() {}

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
