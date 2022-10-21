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
        char alpha = 'a';
        int number = 1;

        for (Element title : data.getTitle()) {
            String titleText = "Title: " + title.text() + "\n";
            textBody = textBody.concat(titleText);
        }

        textBody = textBody.concat("URL: " + data.getURL() + "\n\n");

        //textBody = textBody.concat("Heading: " + data.getFirstHeading().text() + "\n");

        for (Element item : data.getArticle()) {

            String escape = "\n";
            String textAdd;
            String parent = "";
            //select item.attr, check for class, then work accordingly if parent?

            if (item.hasClass("mw-headline")) {
                textAdd = ("= " + item.text() + " =" + escape);
            }
            else {
                textAdd = ("" + item.text() + escape + escape);
            }

            textBody = textBody.concat(textAdd);
        }

        for (Element note : data.getNotes()) {
            String escape = "\n";
            String textAdd;

            if (note.hasClass("mw-headline")) {
                textAdd = ("= " + note.text() + " =" + escape);
            }
            else {
                textAdd = (alpha + ". " + note.text() +  escape);
                alpha++;
            }

            textBody = textBody.concat(textAdd);
            //textBody = textBody.concat(note.text() + "\n");
        }

        textBody = textBody.concat("\n");

        for (Element ref : data.getReferences()) {
            String escape = "\n";
            String textAdd;

            if (ref.hasClass("mw-headline")) {
                textAdd = ("= " + ref.text() + " =" + escape);
            }
            else {
                textAdd = (number + ". " + ref.text() +  escape);
                number++;
            }

            textBody = textBody.concat(textAdd);
        }

        textBody = textBody.concat("\n");

        for (Element bib : data.getBiblio()) {
            String escape = "\n";
            String textAdd;

            if (bib.hasClass("mw-headline")) {
                textAdd = ("= " + bib.text() + " =" + escape);
            }
            else {
                textAdd = (bib.text() + "\n");
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

    public void printItems() {
        for (Element item : data.getArticle()) {

            System.out.println(item.text());
            System.out.println("Parent: " + item.parent().text());
        }
    }

    //goal 1: get the Wikipedia example and dump it as a .txt file.
    //goal 2: parse and organize a simple web page for dumping. (probably just a Wikipedia article itself.)

}
