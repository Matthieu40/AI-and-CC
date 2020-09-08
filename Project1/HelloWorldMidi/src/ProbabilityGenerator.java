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
		for(int i = 0; i < newTokens.size() -1; i++){
			

			T index = alphabet.get(i);
			
			if(index == null) {
				
				T w = newTokens.get(i);
				alphabet.add(w);
				
				alphabet_counts.add(0);
			}
			
			alphabet_counts.get((int) index);
			
		}
	}
	
	
	T generate() {
		T newToken = null;
		//do something here (generate 1 token)
		float rIndex = (float) Math.random();
		
		for(int i=0; i< alphabet.size(); i++) {
			
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
