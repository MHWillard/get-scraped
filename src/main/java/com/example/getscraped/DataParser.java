package com.example.getscraped;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class DataParser {
    //private HTMLData data;
    private Elements toParse;
    public DataParser(Elements elements) {
        toParse = elements;
    }

    public void parseData() {}

    public void cleanData() {}

    public void returnCleanData() {}

    public File createTextFile() {
        File dumpText = new File("output.txt");
        return dumpText;
    }

    public void dumpHeadlinesAsText() {
        //log headline and link to that article
        for (Element headline : toParse) {
            //arm empty text file with createTextfile()
            //save headline.attr as String.format
            //save headline.absURL as string format
            //write this line to our text file
            //when done: we want to save this file as text in the directory
            //log("%s\n\t%s", headline.attr("title"), headline.absUrl("href"));
        }
    }

    //goal 1: get the Wikipedia example and dump it as a .txt file.
    //goal 2: parse and organize a simple web page for dumping. (probably just a Wikipedia article itself.)

}
