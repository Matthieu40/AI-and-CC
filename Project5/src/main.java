/*
 * c2020-2021 Matthieu Legagneur
 * 10/25/20
 */
import java.util.*;
import processing.core.*;

public class main extends PApplet {

	
	public static void main(String[] args) {
		
		PApplet.main("main");
		
	}
	
	public void settings() {
		size(300, 300);

	}
	
	public void setup() {
		fill(120, 50, 240);
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

	Integer[] myList = {3, 3, 3, 5, 5, 7, 7, 7, 2, 3, 5};
	ArrayList<Integer> testList = new ArrayList(Arrays.asList(myList));
	
	char[] list1 = {'a','b','r','a','c','a','d','a','b','r','a'};
	ArrayList<String> List1 = new ArrayList(Arrays.asList(list1));
	
	char[] list2 = {'a','c','a','d','a','a','c','b','d','a'};
	ArrayList<String> List2 = new ArrayList(Arrays.asList(list2));
	
	char[] list3 = {'a','b','c','c','c','d','a','a','d','c','d','a','a','b','c','a','d','a','d'};
	ArrayList<String> List3 = new ArrayList(Arrays.asList(list3));
	
	Node node = new Node(testList);
	//Node node2 = new Node(List2);
	//Node node3 = new Node(List3);
	
	//Declare a tree string - Tree<String> tree = new Tree(L); then tree.train(list) - tree.print()
	//tree<String> tree = new tree(3);
	
 if(key == '1') {
tree<String> tree = new tree(3);
tree.train(List1);
tree.print();

 }else if (key == '2') {
	
 }else if (key == '3') {
	
 }else if (key == '4') {
	
 }
	
	
}



}
