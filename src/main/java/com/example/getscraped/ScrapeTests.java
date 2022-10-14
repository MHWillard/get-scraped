package com.example.getscraped;

public class ScrapeTests {
    private static Scraper scraper = new Scraper();
    private static Parser parser = new Parser();
    private static String link = "https://en.wikipedia.org/wiki/Empyrean_Challenge";

    public static void main(String [] args) {
        scrapeArticle(link);
    }

    private static void scrapeArticle(String link) {
        try {
            scraper.connectDocument(link);
            scraper.prepDataExtract();

            parser.addDataExtract(scraper.getDataExtract());
            parser.createOutput();

            System.out.println("Article scraped.");
        } catch (Exception e) {
            System.out.println("There was an error.");
        }
    }
}
