package com.example.getscraped;

public class ScrapeTests {
    private static Scraper scraper = new Scraper();
    private static Parser parser = new Parser();
    private static String link = "https://en.wikipedia.org/wiki/Empyrean_Challenge";

    private static String[] pages = {"https://en.wikipedia.org/wiki/Empyrean_Challenge","https://en.wikipedia.org/wiki/Ben_Alexander_(actor)","https://en.wikipedia.org/wiki/Still_Public_Enemy_Number_1","https://en.wikipedia.org/wiki/Orchard_Court","https://en.wikipedia.org/wiki/John_Bailey_(New_Zealand_cricketer)","https://en.wikipedia.org/wiki/Aalborg_Municipality"};


    public static void main(String [] args) {
        //scrapeArticle(link);
        //printItems();
        scrapePages();
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

    private static void scrapePages() {

        for (String i : pages) {
            try {
                scraper.connectDocument(i);
                scraper.prepDataExtract();

                parser.addDataExtract(scraper.getDataExtract());
                parser.createOutput();

                System.out.println("Article scraped.");
            } catch (Exception e) {
                System.out.println("There was an error.");
            }
        }
    }

    private static void printItems() {
        try {
            scraper.connectDocument(link);
            scraper.prepDataExtract();

            parser.addDataExtract(scraper.getDataExtract());
            parser.printItems();

        } catch (Exception e) {
            System.out.println("There was an error.");
        }
    }
}
