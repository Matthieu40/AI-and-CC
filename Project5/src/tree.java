/*
 * c2020-2021 Matthieu Legagneur
 * 10/25/20
 * 
 */
import java.util.*;

public class tree<T> {
	int L;
	Node newNode;
	Node root;
	
	tree(){
		L = 3;
	}
	
	
	void train(ArrayList<T> input) {
		for(int i = 1; i <= L; i++ ) {
			for(int j = 0; j <input.size() -(i-1);j++) {
				ArrayList<T> curSequence = new ArrayList<T>(input.subList(0,i));
			//ArrayList<T> curSequence = new ArrayList<T>(newTokens.subList(i - (orderM - 1), i + 1));//reference code from markov chain
			newNode = new Node<T>(curSequence);
			root.addNode(newNode);
			}
		}
		
	}
	
	void print() {
		root.print();
	}
	
	
	
	
}
