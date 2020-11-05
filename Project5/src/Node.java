/*
 * c2020-2021 Matthieu Legagneur
 * 10/25/20
 */
import java.io.PrintStream;
import java.util.*;
public class Node <T>{
	
	ArrayList<Node> children = new ArrayList<>();
	ArrayList<T> tokenSequence = new ArrayList<T>();//check to see if tokensequence is meant to be array list and check for data type
	int count = 1;
	//constructor 
	Node(ArrayList<T> curSequence) {
		// TODO Auto-generated constructor stub
		tokenSequence = curSequence;
	}

	boolean amIASuffix(Node node) {//ask for clarification with this function
		//do something here:
		if(node.getTokenSequence().subList(node.getTokenSequence().size()-tokenSequence.size(), node.getTokenSequence().size()).equals(tokenSequence)) {
			return true;
		}else {
		return false;
		}
	}
	
	boolean addNode(Node<T> node) {
		boolean found = false;
		
		if(tokenSequence.equals(node.getTokenSequence()) ) {
			found = true;
			count++;
		}else if(amIASuffix(node)||(tokenSequence.size()==0)) {
			//add while loop and exit when found
			int index =0;
			while(!found && index < children.size()) {
					children.add(node); 
					index++;
					found = children.get(index).addNode(node);
			if(!found && node.getTokenSequence().size()< tokenSequence.size()) {
				children.add(node);
			}
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
				children.get(i).print(1);
			}
	}
	
	void print(int numSpacesBefore){
		for(int i = 1; i < numSpacesBefore; i++) {
			System.out.print("--> ");
			System.out.println(tokenSequence.get(i));
		}
		for(int j = 0; j < children.size();j++) {
			children.get(j).print(numSpacesBefore+1); // Figure out proper syntax
		}
	}
	
	boolean pMinElimination(int totalTokens,float pMin) {
		
		int prob = 0;
		
		for (int x =0; x < tokenSequence.size(); x++) {
			
			if(totalTokens == (int)tokenSequence.get(x)) {
				prob ++;
			}
		}
		
		boolean shouldRemove = false;
		if(prob / totalTokens-(tokenSequence.size()) < pMin) {
			shouldRemove = true;
		}else {
			for(int y = 0; y < children.size();y++ ) {
				children.get(y).pMinElimination(y, pMin);
				if(shouldRemove == true) {
					children.remove(children.get(y));
				}
			}
		}
		
		return shouldRemove;
		
	}
	
	ArrayList<T> getTokenSequence() {
		return tokenSequence;
	}
	
}
