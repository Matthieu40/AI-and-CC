/*
 * c2020-2021 Matthieu Legagneur
 * 
 * Class: H
 * Description: Demonstration of MIDI file manipulations, etc. & 'MelodyPlayer' sequencer
 * 
 * 9/8/20
 * 
 */

import java.util.*;
public class ProbabilityGenerator<T> {

	ArrayList<T> alphabet;	
	ArrayList<Integer> alphabet_counts;
	
	ProbabilityGenerator(){
		
		alphabet = new ArrayList<T>();
		alphabet_counts = new ArrayList<Integer>();
	}
	
	void train(ArrayList<T> newTokens) {
		//code training
		for(int i = 0; i < newTokens.size(); i++){
			
			
			int index = alphabet.indexOf(newTokens.get(i));
			
			if(index == -1) {
				
				T w = newTokens.get(i);
				alphabet.add(w);
				
				alphabet_counts.add(0);
				index = alphabet.size()-1;
			}
			
			alphabet_counts.set(index, alphabet_counts.get(index)+ 1);
			
		}
	}
	
	void printProbabilityDistribution(ArrayList<T> newTokens)//should this accept parameters??
	{
		//normalize the array and print
		for(int i = 0; i<newTokens.size();i ++){
			
			float rIndex = (float) (Math.random() * (1-0 + 1)+ 0);//placeholder for probability (not sure how to calculate)
		System.out.println("Token: " + newTokens.get(i) + " | " + "Probability: " +  rIndex); 
	} 
		
	}
	
	
	T generate() {
		T newToken = null;
		//do something here (generate 1 token)
		float rIndex = (float) (Math.random() * (1-0 + 1)+ 0);
		 ArrayList<Integer> probs = new ArrayList<>();
		 int sum = 0;
		
		for(int i = 0; i < alphabet_counts.size();i++) {
			sum += alphabet_counts.get(i);
			probs.add(sum/4);
			
		}
		
		
		for(int i=0; i< alphabet.size(); i++) {
			if(rIndex < probs.get(0)) {
				newToken = alphabet.get(0);
			}else if(rIndex < probs.get(1)) {
				newToken = alphabet.get(1);
			}else if(rIndex < probs.get(2)) {
				newToken = alphabet.get(2);
			}else if(rIndex < probs.get(3)){
				newToken = alphabet.get(3);
			}
		}
		
		return newToken;
	}
	
	
	ArrayList<T> generate(int length)
	{
		ArrayList<T> newSequence = new ArrayList<T>();
		for (int i = 0;i<length; i++) {
			newSequence.add(generate());
		}
		
		return newSequence;
	}
}
