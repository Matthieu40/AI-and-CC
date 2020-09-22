import java.util.*;

public class MarkovGenerator<T> extends ProbabilityGenerator<T>{
	
	
	MarkovGenerator(){
		super();
		
	}
	
	T generate() {
		T newToken = null;
		//do something here
		return newToken;
	}
	
	
	void train(ArrayList<T> newTokens) {
		//to declare
		ArrayList<ArrayList<Integer>> transitionTable;

		//to create the ArrayList
		transitionTable = new ArrayList();

		//to add a row
		ArrayList<Integer> myRow = new ArrayList();
		myRow.add(8); //any number

		//to get the 0th (i.e., first) ArrayList or row from our ArrayList of Arraylists:

		ArrayList<Integer> row = transitionTable.get(0);

		//then to get the 0th element from the row (assuming it is both not empty & has been instantiated)
		Integer myElement = row.get(0);

		//System.out.println(row.get(0)); //will print 8.
		
		int lastIndex = -1;
		
		for(int i = 0; i < alphabet.size(); i++ ) {
			
			int tokenIndex = alphabet.size();
			transitionTable.add(myRow);
			
			for(int x = 0; x < transitionTable.size(); x++) {
				
				for(int j = 0; j < transitionTable.get(i).size(); j++) {
					
					transitionTable.add(0);
					
				}
				
			}
			
		}
		
	}
	
	
	ArrayList<T> generate(int length){
		ArrayList<T> newSequence = new ArrayList<T>();
		/*
		  for(int i =o; i< length; i++){
		  	newSequence.add(generate());
		  }
		 */
		return newSequence;
	}
	
	
	ArrayList<T> generate(int length, T initToken){
		ArrayList<T> newSequence = new ArrayList<T>();
		/*
		  for(int i =o; i< length; i++){
		  	newSequence.add(generate());
		  }
		 */
		return newSequence;
	}
	
	
}
