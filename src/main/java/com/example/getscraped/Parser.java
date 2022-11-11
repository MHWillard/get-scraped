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

            String textToAdd = parseItem(item);
            textToAdd = textToAdd.concat("\n");

            textBody = textBody.concat(textToAdd);
        }

        return textBody;
    }

    public File createTextFile(String name) {
        File dir = new File("output");
        String filename = name + ".txt";

        if (!dir.exists()) {
            dir.mkdirs();
        }

        return new File("output/" + filename);
    }

    public void createOutput() throws IOException {
        File file = createTextFile(data.getTitle().text());
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        String textBody = prepareData();

        writer.write(textBody);

        writer.close();
    }

    public void printItems() {
        for (Element item : data.getArticle()) {

            System.out.println(item);
            System.out.println("\n\n");
        }
    }


    public String parseItem(Element item) {
        String textToAdd = "";

        if (item.className().contains("mw-headline")) {
            textToAdd = textToAdd.concat("= " + item.text() + " =");
        }

        if (item.tag().getName().equals("p")) {
            textToAdd = textToAdd.concat("" + item.text() + "\n");
        }

        //if (item.tag().getName().equals("ul") || item.tag().getName().equals("ol")) {
            //textToAdd = textToAdd.concat(parseList(item));
        //}

        if (item.tag().getName().equals("li")) {
            textToAdd = textToAdd.concat("* " + item.text() + "\n");
        }

        if (item.className().contains("wikitable")) {
            textToAdd = textToAdd.concat(parseTable(item));
        }

        return textToAdd;
    }

    public String parseTable(Element tableItem) {
        //for table element: find each caption, th, tr, etc. and print
        String tableText = "";
        Elements headers = tableItem.select("th");
        Elements rows = tableItem.select("tr");

        for (Element header : headers) {
            tableText = tableText.concat(header.text() + " | ");
        }

        tableText = tableText.concat("\n");

        for (Element row : rows) {
            Elements cells = row.select("td");
            for (Element cell : cells) {
                tableText = tableText.concat(cell.text() + " | ");
            }
            tableText = tableText.concat("\n");
        }

        tableText = tableText.concat("\n");
        return tableText;
    }

    public String parseList(Element listItem) {
        String tableText = "";
        Elements li = listItem.select("li");

        for (Element l : li) {
            tableText = tableText.concat("* " + l.text() + "\n");
        }

        return tableText;
    }
}