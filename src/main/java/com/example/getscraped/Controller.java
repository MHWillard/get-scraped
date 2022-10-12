package com.example.getscraped;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.TextAlignment;

public class Controller {

    @FXML
    private Label introText;
    @FXML
    private Label statusText;
    @FXML
    private TextField urlText;

    private Scraper scraper;
    private Parser parser;
    private URL url;

    @FXML
    protected void onScrapeButtonClick() {
        //get text from URL field and throw into URL object
        //scan object for credible URL field and return result as needed

        //if good: do the whole scrape

        url.setURL(urlText.getText());

        if (url.validate()) {
            scrapeArticle(url.getURL());
        } else {
            statusText.setText("Invalid URL.");
        }

        //String link = "https://en.wikipedia.org/wiki/Empyrean_Challenge";


    }

    public void scrapeArticle(String link) {
        try {
            scraper.connectDocument(link);
            scraper.prepDataExtract();

            parser.addDataExtract(scraper.getDataExtract());
            parser.createOutput();

            statusText.setText("Article scraped.");
        } catch (Exception e) {
            System.out.println("There was an error.");
            statusText.setText("There was an error scraping.");
        }
    }

    //@Override
    public void initialize() {
        introText.setText("Get a text version of any Wikipedia article by putting the URL into the field below and clicking Scrape.");
        introText.setWrapText(true);
        introText.setTextAlignment(TextAlignment.CENTER);
        introText.setMaxWidth(400);

        scraper = new Scraper();
        parser = new Parser();
        url = new URL();
    }
}