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
		
	}
	
	T generate() {
		T newToken = null;
		//do something here (generate 1 token)
		return newToken;
	}
}
