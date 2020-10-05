import java.util.*;

public class MarkovChain<T> extends MarkovGenerator<T>  {
	ArrayList<Integer> uniqueAlphabetSequences;
	
	MarkovChain(){
		super();
	}
	
	void Train(ArrayList<T> newTokens, int orderM) {
		
		int tokenIndex = -1;
		int curSequence = -1;
		
		
		for(int i = orderM -1; i < newTokens.size() - 1; i++) {
			curSequence = orderM;
			
			if(curSequence == -1) {
				ArrayList<Integer> rowIndex = new ArrayList(uniqueAlphabetSequences.size());
				
				uniqueAlphabetSequences.add(curSequence);
				
				ArrayList<Integer> myRow = new ArrayList();

				for (int x = 0; x < alphabet.size(); x++) {
					myRow.add(0);
				}

				transitionTable.add(myRow);
				
			}
			
			//find tokenIndex
			tokenIndex = alphabet.indexOf(alphabet.get(i+1));
			
			if(tokenIndex == -1) {
				tokenIndex = alphabet.size();
				alphabet.add(newTokens.get(i));
				for (int j = 0; j < transitionTable.size(); j++) {
					ArrayList<Integer> myRow2 = transitionTable.get(j);
					myRow2.add(0);
				}
			}
			
			//update the counts (Step 4)
			ArrayList<Integer> rowIndex = transitionTable.get(tokenIndex);
			int element = rowIndex.get(tokenIndex);
			element++;
			rowIndex.set(tokenIndex, element);
		}	
		
	}
	
	
}
