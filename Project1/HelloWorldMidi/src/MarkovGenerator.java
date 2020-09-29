import java.util.*;

public class MarkovGenerator<T> extends ProbabilityGenerator<T> {
	ArrayList<ArrayList<Integer>> transitionTable;

	MarkovGenerator() {
		super();
		transitionTable = new ArrayList();

	}

	T generate() {
		T newToken = null;
		// do something here
		return newToken;
	}

	void train(ArrayList<T> newTokens) {

		// to add a row
		// 
		// myRow.add(8); //any number

		// to get the 0th (i.e., first) ArrayList or row from our ArrayList of
		// Arraylists:

		// ArrayList<Integer> row = transitionTable.get(0);

		// then to get the 0th element from the row (assuming it is both not empty & has
		// been instantiated)
		// Integer myElement = row.get(0);

		// System.out.println(row.get(0)); //will print 8.

		int lastIndex = -1;

		for (int i = 0; i < newTokens.size(); i++) {

			int tokenIndex = alphabet.indexOf(newTokens.get(i));

			if (tokenIndex == -1) {
				
				tokenIndex = alphabet.size();
				ArrayList<Integer> myRow = new ArrayList();
				
				for(int x = 0; x < alphabet.size(); x ++) {
					myRow.add(0);
				}
				
				transitionTable.add(myRow);
				
				for (int j = 0; j < transitionTable.size(); j++) {
					ArrayList<Integer> myRow2 = transitionTable.get(j);
					myRow2.add(0);
				}
				alphabet.add(newTokens.get(i));
			}

			if (lastIndex > -1) {
				ArrayList<Integer> curRow = transitionTable.get(lastIndex);
				int element = curRow.get(tokenIndex);
				element ++;
				curRow.set(tokenIndex, element);
			}

			lastIndex = tokenIndex;
			
		}
		System.out.print(transitionTable);
		System.out.println("Test");
	}
	//sum each row then print and divide numbers by the sum of each row - 3 for loops to print - make sure sum is a float value
	
	void printProbabilityDistribution(ArrayList<T> newTokens)
	{
		//normalize the array and print
		for(int i = 0; i<transitionTable.size();i ++){
			
		System.out.println("Token: " + alphabet.get(i) + " | " + "Probability: " +  probs.get(i)); //change to probability.get i); 
		
	} 
		
	}
	
	
	  T generate(T initToken){
		  //int index;
		  for(int i = 0; i < alphabet.size(); i ++) {
			int index = alphabet.indexOf(initToken);
			 ArrayList<Integer> curRow = transitionTable.get(index);
			//sumProbs = curRow;
			initToken = curRow.generate();
		  }
		 
		  return initToken;
	  }
	  
	  	
	
	ArrayList<T> generate(int length) {
		ArrayList<T> newSequence = new ArrayList<T>();
		
		 for(int i = 0; i< length; i++){ newSequence.add(generate()); }
		 
		return newSequence;
	}

	ArrayList<T> generate(int length, T initToken) {
		ArrayList<T> newSequence = new ArrayList<T>();
		
		 for(int i = 0; i< length; i++){ newSequence.add(generate()); }
		 
		return newSequence;
	}

}
