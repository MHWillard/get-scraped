# Get Scraped
Get Scraped is a basic Wikipedia text scraper written in Java utilizing JavaFX and the Jsoup library. I wrote it to grab and organize basic textual information - as such, there's currently no support for pulling things like tables, images, quotes, etc. Since the content of any Wikipedia page can widely vary, it's bound to miss every possible permutation of data, but it tries to grab the basic content you see on most pages.

Writing this scraper was an experiment to learn more about web scraping, working with JavaFX, writing tests, and designing classes and programs. One lesson I learned that I didn't expect to learn was limiting scope and the importance of iteration. As such, I'm putting up this iteration of the scraper with the understanding that further customization can be added later.

## Installation
You can run the project in an IDE or build a fat jar with Maven. Make sure you have the Maven shade plugin in your POM, then run `mvn compile package` in the main directory. It should create a shade folder.

To run, from the CMD line, type `java -jar shade/get-scraper.jar'.

## Usage
Just launch the scraper and put any Wikipedia URL into the text box, then click Scrape. The scraper will try to scrape non-English pages as well, but based on your system's language settings, other languages may or may not display properly. All articles are saved in an 'output' folder in the main directory as text files.

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)