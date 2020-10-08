import java.util.*;

public class MarkovChain<T> extends MarkovGenerator<T>  {
	ArrayList<ArrayList<T>> uniqueAlphabetSequences = new ArrayList<>();
	//ArrayList<T> curSequence = new ArrayList<T>();
	int orderM;
	MarkovChain(int orderM1){
		super();
		orderM = orderM1;
	}
	
	void train(ArrayList<T> newTokens) {
		
		int tokenIndex = -1;
		int rowIndex = -1;
		//ArrayList<T> curSequence = new ArrayList<>();
		
		
		for(int i = orderM -1; i < newTokens.size() - 1; i++) {
			//not adding to alphabet
			ArrayList<T> curSequence = new ArrayList<T>(newTokens.subList(i - (orderM - 1), i + 1));
			//for loop or sublist to get orderM elements of newTokens
			
			//Find curSequence in unique alphabet sequence
			 rowIndex = uniqueAlphabetSequences.indexOf(curSequence);
			 
			if(rowIndex == -1) {
				
				rowIndex = uniqueAlphabetSequences.size();
				
				uniqueAlphabetSequences.add(curSequence);
				
				ArrayList<Integer> myRow = new ArrayList();

				for (int x = 0; x < alphabet.size(); x++) {
					myRow.add(0);
				}

				transitionTable.add(myRow);
				
			}
			 
			
			

			tokenIndex = alphabet.indexOf(newTokens.get(i+1));
			//System.out.println(tokenIndex);
			
			if(tokenIndex == -1) // what should I substitute -1 with?
			{
				tokenIndex = alphabet.size();
				alphabet.add(newTokens.get(i + 1));
				for (int j = 0; j < transitionTable.size(); j++) {
					ArrayList<Integer> myRow2 = transitionTable.get(j);
					myRow2.add(0);
				}
			}
			
			//update the counts (Step 4)
			ArrayList<Integer> rowIndex2 = new ArrayList();
			rowIndex2 = transitionTable.get(rowIndex);
			int element = rowIndex2.get(tokenIndex);
			element++;
			rowIndex2.set(tokenIndex, element);
		}	
			//System.out.println(uniqueAlphabetSequences);
			//print transition table
			//System.out.println(transitionTable);
			
	}
	
	void printProbabilityDistribution(ArrayList<T> newTokens) {
		// normalize the array and print
		//test print - System.out.print(transitionTable);
		//Reformat this *************
		//print alphabet 
		for (int i = 0; i < transitionTable.size(); i++) {
			ArrayList<T> curSequence = new ArrayList<T>(newTokens.subList(i - (orderM - 2), i + 1));//check to see what value would display both numbers
			ArrayList<Integer> row = transitionTable.get(i);
			float sum = arraySum(row);
				updateProbs(row, sum);
				// printing loop
				// is it alphabet or transition table?
				System.out.print(curSequence + " ");//current sequences instead of alphabet
				for(int x = 0; x < probs.size(); x++) {
				//System.out.print(alphabet.get(i) + "  " + probs.get(x) + " "); 
					System.out.print(probs.get(x) + " "); 
				}
			System.out.println();
		}
	
	}
	
	
}
