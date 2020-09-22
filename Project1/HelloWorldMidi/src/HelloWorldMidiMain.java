
/*
 * c2020-2021 Matthieu Legagneur
 * 
 * Class: H
 * Description: Demonstration of MIDI file manipulations, etc. & 'MelodyPlayer' sequencer
 * 
 * 9/8/20
 * 
 */

import processing.core.*;

import java.util.*; 

//importing the JMusic stuff
import jm.music.data.*;
import jm.JMC;
import jm.util.*;
import jm.midi.*;

import java.io.UnsupportedEncodingException;
import java.net.*;

//import javax.sound.midi.*;

			//make sure this class name matches your file name, if not fix.
public class HelloWorldMidiMain extends PApplet {

	MelodyPlayer player; //play a midi sequence
	MidiFileToNotes midiNotes; //read a midi file

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("HelloWorldMidiMain"); //change this to match above class & file name 

	}

	//setting the window size to 300x300
	public void settings() {
		size(300, 300);

	}

	//doing all the setup stuff
	public void setup() {
		fill(120, 50, 240);

	//creates generator for pitch and rhythm
		ProbabilityGenerator<Integer> pitchGenerator= new ProbabilityGenerator<Integer>();
		ProbabilityGenerator<Double> rhythmGenerator= new ProbabilityGenerator<Double>();
		
		
				
		// returns a url
		String filePath = getPath("mid/MaryHadALittleLamb.mid");
		// playMidiFile(filePath);

		midiNotes = new MidiFileToNotes(filePath); //creates a new MidiFileToNotes -- reminder -- ALL objects in Java must 
													//be created with "new". Note how every object is a pointer or reference. Every. single. one.


//		// which line to read in --> this object only reads one line (or ie, voice or ie, one instrument)'s worth of data from the file
		midiNotes.setWhichLine(0);
		
		//training
		pitchGenerator.train(midiNotes.getPitchArray());
		rhythmGenerator.train(midiNotes.getRhythmArray());
		
		player = new MelodyPlayer(this, 100.0f);

		player.setup();
		player.setMelody(pitchGenerator.generate(20));
		player.setRhythm(rhythmGenerator.generate(20));
	}

	public void draw() {
	   player.play(); //play each note in the sequence -- the player will determine whether is time for a note onset
		
		textSize(12);
		fill(0, 102, 153);
		text("Press 1 to start the unit test!", width/10, height/2);
	}

	//this finds the absolute path of a file
	String getPath(String path) {

		String filePath = "";
		try {
			filePath = URLDecoder.decode(getClass().getResource(path).getPath(), "UTF-8");

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filePath;
	}

	//this function is not currently called. you may call this from setup() if you want to test
	//this just plays the midi file -- all of it via your software synth. You will not use this function in upcoming projects
	//but it could be a good debug tool.
	void playMidiFile(String filename) {
		Score theScore = new Score("Temporary score");
		Read.midi(theScore, filename);
		Play.midi(theScore);
	}

	//this starts & restarts the melody.
	public void keyPressed() {
		
		MidiFileToNotes midiNotesMary; //Read a midi file
		String filePath = getPath("mid/MaryHadALittleLamb.mid");
		midiNotesMary = new MidiFileToNotes(filePath); 
		midiNotesMary.setWhichLine(0);
		
		ProbabilityGenerator<Integer> pitchGenerator= new ProbabilityGenerator<Integer>();
		ProbabilityGenerator<Double> rhythmGenerator= new ProbabilityGenerator<Double>();
		MarkovGenerator<Integer> pitchGenerator2= new MarkovGenerator<Integer>();
		MarkovGenerator<Double> rhythmGenerator2= new MarkovGenerator<Double>();
		pitchGenerator.train(midiNotesMary.getPitchArray());
		rhythmGenerator.train(midiNotesMary.getRhythmArray());
		pitchGenerator2.train(midiNotesMary.getPitchArray());
		rhythmGenerator2.train(midiNotesMary.getRhythmArray());
		
		
		if (key == ' ') {
			player.reset();
			println("Melody started!");
			
		}
		else if (key == '1'){
			//run unit 1
			
			pitchGenerator.printProbabilityDistribution(midiNotesMary.getPitchArray());
			
			rhythmGenerator.printProbabilityDistribution(midiNotesMary.getRhythmArray());
			
			//System.out.println(midiNotesMary.getPitchArray());
			//System.out.println(midiNotesMary.getRhythmArray());
		}else if(key == '2') {
			
			pitchGenerator.train(midiNotesMary.getPitchArray());
			rhythmGenerator.train(midiNotesMary.getRhythmArray());
			
			System.out.println("pitches:");
			System.out.println(pitchGenerator.generate(20));
			
			
			System.out.println("rhythm:");
			System.out.println(rhythmGenerator.generate(20));
			
			
			
		}else if (key == '3') {
			
			pitchGenerator.train(midiNotesMary.getPitchArray());
			System.out.println("Pitches:");
			for(int i = 1; i < 10000; i++) {
				ArrayList<Integer> newSong = pitchGenerator.generate(20);
				ProbabilityGenerator<Integer> probDistGen = new ProbabilityGenerator<Integer>();
				probDistGen .train(newSong);
			}
			pitchGenerator.printProbabilityDistribution(midiNotesMary.getPitchArray());
			
			rhythmGenerator.train(midiNotesMary.getRhythmArray());
			System.out.println("Rhythm:");
			for(int i = 1; i < 10000; i++) {
				ArrayList<Double> newSong = rhythmGenerator.generate(20);
				ProbabilityGenerator<Double> probDistGen = new ProbabilityGenerator<Double>();
				probDistGen.train(newSong);
			}
			rhythmGenerator.printProbabilityDistribution(midiNotesMary.getRhythmArray());
			
		}else if (key == '4') {
			
			pitchGenerator2.printProbabilityDistribution(midiNotesMary.getPitchArray());
			
			rhythmGenerator2.printProbabilityDistribution(midiNotesMary.getRhythmArray());
			
		}
		
		
	}
}
