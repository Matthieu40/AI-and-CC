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
	// add probability array and update it in train
	ArrayList<Float> sumProbs;
	ArrayList<Float> probs;
	float total = 0;
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
		
		//find total and calculate new probability array from the alphabet count array0
		
		total += newTokens.size();
		 probs = new ArrayList<>();
		
		for(int i = 0;i < alphabet_counts.size();i++) {
			float prob = alphabet_counts.get(i) / total;
			probs.add (prob);
		}
		
	}
	
	void printProbabilityDistribution(ArrayList<T> newTokens)//should this accept parameters??
	{
		//normalize the array and print
		for(int i = 0; i<alphabet.size();i ++){
			
		System.out.println("Token: " + alphabet.get(i) + " | " + "Probability: " +  probs.get(i)); //change to probability.get i); 
		
	} 
		
	}
	
	
	T generate() {// switch to how it was done in the lecture
		//T newToken = null;
		//do something here (generate 1 token)
		 sumProbs = new ArrayList<>();
		sumProbs.add(probs.get(0));
		
		for(int i=1; i< probs.size()-1; i++) {
			sumProbs.add(probs.get(i) + sumProbs.get(i-1));
		}
		sumProbs.add((float) 1);
		
		boolean found = false;
		int i = 0;
		float rIndex = (float) Math.random();
		while(!found && i < sumProbs.size()) {
			found = rIndex < sumProbs.get(i);
			i++;
		}
		
		
		return alphabet.get(i - 1);
		
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
