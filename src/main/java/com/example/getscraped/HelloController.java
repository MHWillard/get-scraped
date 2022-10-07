package com.example.getscraped;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.TextAlignment;

public class HelloController {

    @FXML
    private Label introText;
    @FXML
    private Label welcomeText;
    @FXML
    private Label statusText;
    @FXML
    private TextField url;

    private Scraper scraper;
    private Parser parser;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onScrapeButtonClick() {
        String link = "https://en.wikipedia.org/wiki/Empyrean_Challenge";

        try {
            scraper.connectDocument(link);
            scraper.prepDataExtract();
            //scraper.prepStuff();

            parser.addDataExtract(scraper.getDataExtract());
            parser.createOutput();

            statusText.setText("Web page scraped.");
        } catch (Exception e) {
            System.out.println("There was an error.");
            statusText.setText("There was an error scraping.");
        }
    }

    //@Override
    public void initialize() {
        introText.setText("Welcome to GetScraped! Provide a URL below and click the button and the app will scrape the web page's content and export as a handy .txt file.");
        introText.setWrapText(true);
        introText.setTextAlignment(TextAlignment.CENTER);
        introText.setMaxWidth(400);

        scraper = new Scraper();
        parser = new Parser();
    }
}