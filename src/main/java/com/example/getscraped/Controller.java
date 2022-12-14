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

        url.setURL(urlText.getText());

        if (url.validate()) {
            scrapeArticle(url.getURL());
        } else {
            statusText.setText("Invalid URL.");
        }


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

        scraper = new Scraper();
        parser = new Parser();
        url = new URL();
    }
}