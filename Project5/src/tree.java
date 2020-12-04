/*
 * c2020-2021 Matthieu Legagneur
 * 10/25/20
 * 
 */
import java.util.*;

public class tree<T> {
	int L;
	int pMin;
	int totalInputTokens;
	Node newNode;
	Node root = new Node(new ArrayList<T>());
	
	
	tree(int x,int min){
		L = x;
		pMin = min;
	}
	
	
	void train(ArrayList<T> input) {
		for(int i = 1; i <= L; i++ ) {
			for(int j = 0; j <input.size() -(i-1);j++) {
				ArrayList<T> curSequence = new ArrayList<T>(input.subList(j,i));//incorrect. Correct this***
				//ArrayList<T> curSequence = new ArrayList<T>(newTokens.subList(i - (orderM - 1), i + 1));
			newNode = new Node<T>(curSequence);
			root.addNode(newNode);
			}
		}
		
		totalInputTokens += input.size();
		 
		root.pMinElimination(totalInputTokens,pMin);
	
	}
	
	void print() {
		root.print();
	}
	
	
	
	
}
