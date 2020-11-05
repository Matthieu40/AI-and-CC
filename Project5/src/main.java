/*
 * c2020-2021 Matthieu Legagneur
 * 10/25/20
 */
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;
import processing.core.*;

public class main extends PApplet {

	MidiFileToNotes midiNotes;
	
	public static void main(String[] args) {
		
		PApplet.main("main");
		
	}
	
	public void settings() {
		size(300, 300);

	}
	
	public void setup() {
		fill(120, 50, 240);
		
	}
	
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
	
public void draw() {
		
		textSize(12);
		fill(0, 102, 153);
		text("Press 1 to start the unit test1", width/10, height/2);
		text("Press 2 to start the unit test2", width/10, height/2 + 20);
		text("Press 3 to start the unit test3", width/10, height/2 + 40);
		text("Press 4 to start the unit test4", width/10, height/2 + 60);
	}

public void keyPressed() {

	MidiFileToNotes midiNotesMary; //Read a midi file
	String filePath = getPath("mid/MaryHadALittleLamb.mid");
	midiNotesMary = new MidiFileToNotes(filePath); 
	midiNotesMary.setWhichLine(0);
	
	Integer[] myList = {3, 3, 3, 5, 5, 7, 7, 7, 2, 3, 5};
	ArrayList<Integer> testList = new ArrayList(Arrays.asList(myList));
	
	Integer[] myList2 = {2,3,5};
	ArrayList<Integer> testList2 = new ArrayList(Arrays.asList(myList2));
	
	char[] list1 = {'a','b','r','a','c','a','d','a','b','r','a'};
	ArrayList<String> List1 = new ArrayList(Arrays.asList(list1));
	
	char[] list2 = {'a','c','a','d','a','a','c','b','d','a'};
	ArrayList<String> List2 = new ArrayList(Arrays.asList(list2));
	
	char[] list3 = {'a','b','c','c','c','d','a','a','d','c','d','a','a','b','c','a','d','a','d'};
	ArrayList<String> List3 = new ArrayList(Arrays.asList(list3));
	
	ArrayList<String> List4 = new ArrayList(Arrays.asList(midiNotesMary.getMelody()));
	
	//Node node2 = new Node(List2);
	//Node node3 = new Node(List3);
	//Declare a tree string - Tree<String> tree = new Tree(L); then tree.train(list) - tree.print()
	//tree<String> tree = new tree(3);
	
 if(key == '1') {
	 //testing amIASuffix
//	 Node node = new Node(testList);
//	 Node node2 = new Node(testList2);
//	 System.out.println(node2.amIASuffix(node));
	 
	 tree<String> tree = new tree(3,0);
	 tree.train(List1);
	 tree.print();

 }else if (key == '2') {
	 tree<String> tree2 = new tree(3,0);
	 tree2.train(List2);
	 tree2.print();
 }else if (key == '3') {
	 tree<String> tree3 = new tree(3,0);
	 tree3.train(List3);
	 tree3.print();
 }else if (key == '4') {
	 tree<String> tree4 = new tree(3,0);
	 tree4.train(List4);
	 tree4.print();
 }
	
	
}



}
