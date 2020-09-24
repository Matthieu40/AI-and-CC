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
				
				
				for (int j = 0; j < transitionTable.size(); j++) {
					ArrayList<Integer> myRow2 = transitionTable.get(j);
					myRow2.add(0);
				}
				alphabet.add(newTokens.get(i));
			}

			if (lastIndex > -1) {
				T w = newTokens.get(i);
				alphabet.add(w);
				
				alphabet_counts.add(0);
				tokenIndex = alphabet.size()-1;
			}

			lastIndex = tokenIndex;

		}
	}

	ArrayList<T> generate(int length) {
		ArrayList<T> newSequence = new ArrayList<T>();
		/*
		 * for(int i =o; i< length; i++){ newSequence.add(generate()); }
		 */
		return newSequence;
	}

	ArrayList<T> generate(int length, T initToken) {
		ArrayList<T> newSequence = new ArrayList<T>();
		/*
		 * for(int i =o; i< length; i++){ newSequence.add(generate()); }
		 */
		return newSequence;
	}

}
