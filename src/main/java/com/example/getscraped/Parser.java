package com.example.getscraped;

import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Parser {
    private DataExtract data;
    public Parser() {
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

        for (Element item : data.getArticle()) {

            String escape = "\n";
            String textAdd;

            if (item.hasClass("mw-headline")) {
                textAdd = ("= " + item.text() + " =" + escape);
            }
            else {
                textAdd = ("" + item.text() + escape + escape);
            }

            textBody = textBody.concat(textAdd);
        }

        /*for (Element note : data.getNotes()) {
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
        }*/

        textBody = textBody.concat("\n");

        /*for (Element ref : data.getReferences()) {
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
        }*/

        textBody = textBody.concat("\n");

        /*for (Element bib : data.getBiblio()) {
            String escape = "\n";
            String textAdd;

            if (bib.hasClass("mw-headline")) {
                textAdd = ("= " + bib.text() + " =" + escape);
            }
            else {
                textAdd = (bib.text() + "\n");
            }

            textBody = textBody.concat(textAdd);
        }*/

        return textBody;
    }

    public File createTextFile(String name) {
        File dir = new File("output");
        String filename = name + ".txt";

        if (!dir.exists()) {
            dir.mkdirs();
        }

        //return new File("/output/" + name + ".txt");
        return new File("output/" + filename);
    }

    public void createOutput() throws IOException {
        File file = createTextFile(data.getTitle().text());
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        //File file = new File("C:\\user\\Desktop\\dir1\\dir2\\filename.txt");
        //file.getParentFile().mkdirs();
        //FileWriter writer = new FileWriter(file);

        String textBody = prepareData();

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
