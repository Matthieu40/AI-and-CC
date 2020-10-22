/* Programmer: Matthieu Legagneur
 * Date: Created Fall 2018, Modified 2020
 * This class is a template for creating a twitterbot & also demonstrated web-scraping
 */


import processing.core.*;

import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import com.jaunt.JauntException;

//This class serves as a template for creating twitterbots and demonstrates string tokenizing and web scraping and the use of the 
//twitter API
public class TwitterBotMain extends PApplet {

	private ArrayList<String> tokens;
	private static String HEYER_TWITTER_URL = "https://twitter.com/MatthieuL40"; // this is mine, you should use yours
	private static int TWITTER_CHAR_LIMIT = 140; // I understand this has changed... but forget limit

	// useful constant strings -- for instance if you want to make sure your tweet
	// ends on a space or ending punctuation, etc.
	private static final String fPUNCTUATION = "\",.!?;:()/\\";
	private static final String fENDPUNCTUATION = ".!?;,";
	private static final String fREALENDPUNCTUATION = ".!?";

	private static final String fWHITESPACE = "\t\r\n ";

	// example twitter hastag search term
	private static final String fPASSIVEAGG = "passiveaggressive";
	private static final String fCOMMA = ",";

	// handles twitter api
	TwitterInteraction tweet;

	boolean update = false;
	String status = " ";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("TwitterBotMain"); // Not really using processing functionality but ya know, you _could_. UI not
										// required.

	}

	public void settings() {
		size(300, 300); // dummy window

	};

	public void setup() {
		tweet = new TwitterInteraction();

//NOTE: everything starts uncommented. Comment out the calls that you would like to try and use.

		loadNovel("data2/GatsbyExcerpts.txt"); // TODO: must train from another source
		println("Token size:" + tokens.size());// uncomment later

//		ArrayList<String> seed = new ArrayList();
//		seed.add("I");
//		seed.add("should");
//		seed.add("in");
//		seed.add("my");

		// TODO: train an AI algorithm (eg, Markov Chain) and generate text for markov
		// chain status
		// declare markov chain
		MarkovGenerator<String> mc = new MarkovGenerator<String>();
		mc.train(tokens);// replace with tokens & Mc*****
		// since I couldnt read the file, I had trouble figuring out how to turn the
		// file text into tokens

		// can train on twitter statuses -- note: in your code I would put this part in
		// a separate function
		// but anyhow, here is an example of searrching twitter hashtag. You have to pay
		// $$ to the man to get more results. :(
		// see TwitterInteraction class
		ArrayList<String> tweetResults = tweet.searchForTweets("Jay Gatsby");
		for (int i = 0; i < tweetResults.size(); i++) {
			println(tweetResults.get(i)); // just prints out the results for now
			TextTokenizer tokenizer1 = new TextTokenizer(tweetResults.get(i));
			// use in markov gen
		}
		// Make sure within Twitter limits (used to be 140 but now is more?)
		// String status = "Hello World -- I am a twitterbot";
		// figure out how to set status to tweet data******///
		// uncomment this after setting the status to the tweet data
		mc.train(tweetResults);
		// for loop for updating status
		ArrayList<String> text = mc.generate(42);//why doesn't twitter char work?
		Iterator<String> itr = text.iterator();
		//String status = " ";

		while (itr.hasNext()) {
			Object element = itr.next();
			status += element + " ";
		}
		
//		if(update) {
//			
//		tweet.updateTwitter(status);
//		
//		}

		// prints the text content of the sites that come up with the google search of
		// dogs
//		//you may use this content to train your AI too
		// If used, this just prints the results and doesn't add them to an array ******
//		Scraper scraper = new Scraper(); 
//		ArrayList<String> results;
//		try {
//			results = scraper.scrapeGoogleResults("Jay Gatsby");
//			
//			//print your results
//			System.out.println(results); 
//			
////			scraper.scrape("http://google.com",  "Jay Gatsby"); //see class documentation
		// Tokenize scrapper data?*****//
		// train data on markov generator******//
		// set the data equal to status then update******///
//
//		} catch (JauntException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	// this loads the novel 'The Grand Sophy' given a path p -- but really will load
	// any file.
	void loadNovel(String p) {
		String filePath = getPath(p);
		Path path = Paths.get(
				"C:\\Users\\boyge\\OneDrive\\Documents\\school 2020-2021\\eclipse projects\\Working Dir\\Project4\\TwitterBotTemplate\\bin\\data2\\GatsbyExcerpts.txt");
		tokens = new ArrayList<String>();

		try {
			List<String> lines = Files.readAllLines(path);

			for (int i = 0; i < lines.size(); i++) {

				TextTokenizer tokenizer = new TextTokenizer(lines.get(i));
				ArrayList<String> t = tokenizer.parseSearchText();
				tokens.addAll(t);
			}

		} catch (Exception e) {
			e.printStackTrace();
			println("Oopsie! We had a problem reading a file!");
		}
	}

	void printTokens() {
		for (int i = 0; i < tokens.size(); i++)
			print(tokens.get(i) + " ");
	}

	// get the relative file path
	String getPath(String path) {

		String filePath = "";
		try {
			filePath = URLDecoder.decode(getClass().getResource(path).getPath(), "UTF-8");

			filePath = filePath.substring(1, filePath.length() - 1);

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filePath;
	}

	public void draw() {
		// ellipse(width / 2, height / 2, second(), second());
		textSize(12);
		fill(0, 102, 153);
		text("Press any key to update Twitter status!", width/10, height/2);

	}
	
	public void keyPressed() {
		if (key == ' ') {
			tweet.updateTwitter(status);
			
		}
	}

}
