package com.example.getscraped;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.TextAlignment;
import javafx.fxml.Initializable;

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

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onScrapeButtonClick() {
        statusText.setText("Web page successfully scraped.");

        try {
            scraper.connectDocument();
            scraper.grabHeadlines(scraper.getDocument());
            scraper.printHeadlines(scraper.getNewsHeadlines());
        } catch (Exception e) {
            System.out.println("There was an error.");
        }
    }

    //@Override
    public void initialize() {
        introText.setText("Welcome to GetScraped! Provide a URL below and click the button and the app will scrape the web page's content and export as a handy .txt file.");
        introText.setWrapText(true);
        introText.setTextAlignment(TextAlignment.CENTER);
        introText.setMaxWidth(400);

        scraper = new Scraper();
    }
}