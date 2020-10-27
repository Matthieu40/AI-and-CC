/*
 * c2020-2021 Matthieu Legagneur
 * 10/25/20
 */
import java.util.*;
public class Node <Node>extends tree{
	
	ArrayList<Node> children = new ArrayList<>();
	ArrayList<Node> tokenSequence = new ArrayList<>();//check to see if tokensequence is meant to be array list and check for data type
	
	//constructor (ask about how to correctly format it
	<T> Node(ArrayList<T> curSequence) {
		// TODO Auto-generated constructor stub
	}

	boolean amIASuffix(Node node) {//ask for clarification with this function
		//do something here:
		return false;
	}
	
	boolean addNode(Node node) {
		boolean found = false;
		if(tokenSequence == node) {
			found = true;
		}else if(amIASuffix(node)||(tokenSequence.size()==0)) {
			
			if(found = false && ((ArrayList<Node>) node).size()/*check syntax for node's tokenSequence*/ < tokenSequence.size()) {
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
				//node.print(1);
			}
	}
	
	void print(int numSpacesBefore){
		for(int i = 1; i < numSpacesBefore; i++) {
			System.out.print("--> ");
			System.out.println(tokenSequence.get(i));
		}
		for(int j = 0; j < children.size();j++) {
			//node.print(numSpacesBefore+1); // Figure out proper syntax
		}
	}
	
}
