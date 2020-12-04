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
import rita.*;

//This class serves as a template for creating twitterbots and demonstrates string tokenizing and web scraping and the use of the 
//twitter API
//for this project I used the twitterbot template, markov generators, and the rita library functions
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

		loadNovel("data2/quotes.txt"); // TODO: must train from another source
		println("Token size:" + tokens.size());// uncomment later

		// TODO: train an AI algorithm (eg, Markov Chain) and generate text for markov
		// chain status
		
		MarkovGenerator<String> mc = new MarkovGenerator<String>();
		mc.train(tokens);// replace with tokens & Mc*****
	
		// can train on twitter statuses -- note: in your code I would put this part in
		// a separate function
		// but anyhow, here is an example of searrching twitter hashtag. You have to pay
		// $$ to the man to get more results. :(
		// see TwitterInteraction class
		ArrayList<String> tweetResults = tweet.searchForTweets("#inspiration");
		for (int i = 0; i < tweetResults.size(); i++) {
			println(tweetResults.get(i)); // just prints out the results for now
			TextTokenizer tokenizer1 = new TextTokenizer(tweetResults.get(i));
			// use in markov gen
		}
		// Make sure within Twitter limits (used to be 140 but now is more?)
		// String status = "Hello World -- I am a twitterbot";
		
		mc.train(tweetResults);
		// for loop for updating status
		ArrayList<String> text = mc.generate(42);//why doesn't twitter char work?
		Iterator<String> itr = text.iterator();
		//String status = " ";

		while (itr.hasNext()) {
			Object element = itr.next();
			status += element + " ";
		}
		

	}

	// this loads the text file from file path on my pc -- but really will load
	// any file.
	void loadNovel(String p) {
		String filePath = getPath(p);
		Path path = Paths.get(
				"C:\\Users\\boyge\\OneDrive\\Documents\\school 2020-2021\\eclipse projects\\Working Dir\\Project4\\TwitterBotTemplate\\bin\\data2\\quotes.txt");
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
		//using rita functions to scrape text from file and put it into coherent sentences
		RiMarkov rm = new RiMarkov(3);
		rm.loadFrom("C:\\Users\\boyge\\OneDrive\\Documents\\school 2020-2021\\eclipse projects\\Working Dir\\Project4\\TwitterBotTemplate\\bin\\data2\\quotes.txt");
		status = rm.generateSentence();
		
		
		if (key == ' ') {
			tweet.updateTwitter(status);
			
		}
	}

}
