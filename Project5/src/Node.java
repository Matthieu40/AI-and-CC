/*
 * c2020-2021 Matthieu Legagneur
 * 10/25/20
 */
import java.io.PrintStream;
import java.util.*;
public class Node <Node, T>extends tree{
	
	ArrayList<Node> children = new ArrayList<>();
	ArrayList<T> tokenSequence = new ArrayList<T>();//check to see if tokensequence is meant to be array list and check for data type
	
	//constructor 
	Node(ArrayList<T> curSequence) {
		// TODO Auto-generated constructor stub
		tokenSequence = curSequence;
	}

	boolean amIASuffix(Node node) {//ask for clarification with this function
		//do something here:
		if(node.getTokenSequence().sublist(0,node.getTokenSequence().size()-1).equals(tokenSequence.subList(0, tokenSequence.size()-1))) {
			return true;
		}else {
		return false;
		}
	}
	
	boolean addNode(Node node) {
		boolean found = false;
		//node.setTokenSequence(tokenSequence);
		if(tokenSequence == node) {
			found = true;
		}else if(amIASuffix(node)||(tokenSequence.size()==0)) {
			
			if(found = false && node.getTokenSequence() < tokenSequence.size()) {//is node supposed to be a new obj? why is this wrong?
					children.add(node);
					found = true;
			}
		}
		
		return found;
	}
	
	void print() {
		//print tokenSequence
			System.out.print(tokenSequence);
			//figure out how to print each node in children(syntax)
			//temp
			for(int i = 0; i< children.size(); i++) {
				((PrintStream) children.get(i)).print(1);
			}
	}
	
	void print(int numSpacesBefore){
		for(int i = 1; i < numSpacesBefore; i++) {
			System.out.print("--> ");
			System.out.println(tokenSequence.get(i));
		}
		for(int j = 0; j < children.size();j++) {
			((PrintStream) children.get(j)).print(numSpacesBefore+1); // Figure out proper syntax
		}
	}
	
//	void setTokenSequence(ArrayList<T> tokenSequence) {
//		this.tokenSequence = new ArrayList<T>();
//	}
	
	ArrayList<T> getTokenSequence() {
		return tokenSequence;
	}
	
}
