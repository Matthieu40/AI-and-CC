/*
 * c2020-2021 Matthieu Legagneur
 * 10/25/20
 */
import java.util.*;
public class main {
	
	
	public static void main(String[] args) {
		Integer[] myList = {3, 3, 3, 5, 5, 7, 7, 7, 2, 3, 5};
		ArrayList<Integer> testList = new ArrayList(Arrays.asList(myList));
		
		char[] list1 = {'a','b','r','a','c','a','d','a','b','r','a'};
		ArrayList<String> List1 = new ArrayList(Arrays.asList(list1));
		
		char[] list2 = {'a','c','a','d','a','a','c','b','d','a'};
		ArrayList<String> List2 = new ArrayList(Arrays.asList(list2));
		
		char[] list3 = {'a','b','c','c','c','d','a','a','d','c','d','a','a','b','c','a','d','a','d'};
		ArrayList<String> List3 = new ArrayList(Arrays.asList(list3));
		
		Node node = new Node(testList);
		Node node2 = new Node(List2);
		Node node3 = new Node(List3);
		
		node.train(List1);
	}
	
}
