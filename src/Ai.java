import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.*;
import java.io.FileWriter; 
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;


public class Ai {

	public static void main(String[] args) {
		Stack<char[]> stack_S1 = new Stack<char[]>(); // Initialising stack for state 1 
		Stack<char[]> stack_S2 = new Stack<char[]>(); // Initialising stack for state 2 
		Set<String> visited_S1 = new HashSet<String>(); // Initialising visited states set for state 1 inputted
		Set<String> visited_S2 = new HashSet<String>(); // Initialising visited states set for state 2 inputted
		Set<String> reachables_S1 = new HashSet<String>(); // Initialising set storing all reachable states from state 1 inputted
		Set<String> reachables_S2 = new HashSet<String>(); // Initialising set storing all reachable states from state 2 inputted
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter contents of puzzle S1 in order using a space to represent the blank: "); // Prompting user input for state S1
		char[] state1 = sc.nextLine().toCharArray(); // Setting user input as S1 array
		System.out.print("Enter contents of puzzle S2 in order using a space to represent the blank: "); // Prompting user input for state S2
		char[] state2 = sc.nextLine().toCharArray(); // Setting user input as S2 array
		
		sc.close();
		
		stack_S1.push(state1); // Push state 1 to front of it's stack
		stack_S2.push(state2); // Push state 2 to front of it's stack
		
		while (stack_S1.size() > 0 && stack_S2.size() > 0) { // End when stacks are empty, when all possible states have been visited
			System.out.println(stack_S1.size());
			char[] S1 = stack_S1.peek(); // Set the state being expanded to the state at the top of stack1, following DFS traversal
			char[] S2 = stack_S2.peek(); //set the state being expanded to the state at the top of the stack, following DFS traversal
			stack_S1.pop(); //pop state at the top of stack 1 so it is not visited again
			stack_S2.pop(); //pop state at the top of stack 2 so it is not visited again
			visited_S1.add(Arrays.toString(S1)); //add state 1 being expanded/visited to visited set for state 1
			visited_S2.add(Arrays.toString(S2)); //add state 2 being expanded/visited to visited set for state 2
			
			int blankPos_S1 = new String(S1).indexOf(' '); //get the index for the blank position for state 1
			int blankPos_S2 = new String(S2).indexOf(' '); //get the index for the blank position for state 2
			
			ArrayList<String> moves_S1 = new ArrayList<String>(); //initialise arraylist to store possible moves from state 1
			ArrayList<String> moves_S2 = new ArrayList<String>(); //initialise arraylist to store possible moves from state 2
			
			//checking the index of the blank position for state 1 and adding moves available to arraylist for state 1
			if (blankPos_S1 == 0 || blankPos_S1 == 1 || blankPos_S1 == 3 || blankPos_S1 == 4 || blankPos_S1 == 6 || blankPos_S1 == 7) {
				moves_S1.add("right");
			}
			if (blankPos_S1 == 1 || blankPos_S1 == 2 || blankPos_S1 == 4 || blankPos_S1 == 5 || blankPos_S1 == 7 || blankPos_S1 == 8) {
				moves_S1.add("left");
			}
			if (blankPos_S1 == 3 || blankPos_S1 == 4 || blankPos_S1 == 5 || blankPos_S1 == 6 || blankPos_S1 == 7 || blankPos_S1 == 8) {
				moves_S1.add("up");
			}
			if (blankPos_S1 == 0 || blankPos_S1 == 1 || blankPos_S1 == 2 || blankPos_S1 == 3 || blankPos_S1 == 4 || blankPos_S1 == 5) {
				moves_S1.add("down");
			}
			
			//checking the index of the blank position for state 2 and adding moves available to arraylist for state 2
			if (blankPos_S2 == 0 || blankPos_S2 == 1 || blankPos_S2 == 3 || blankPos_S2 == 4 || blankPos_S2 == 6 || blankPos_S2 == 7) {
				moves_S2.add("right");
			}
			if (blankPos_S2 == 1 || blankPos_S2 == 2 || blankPos_S2 == 4 || blankPos_S2 == 5 || blankPos_S2 == 7 || blankPos_S2 == 8) {
				moves_S2.add("left");
			}
			if (blankPos_S2 == 3 || blankPos_S2 == 4 || blankPos_S2 == 5 || blankPos_S2 == 6 || blankPos_S2 == 7 || blankPos_S2 == 8) {
				moves_S2.add("up");
			}
			if (blankPos_S2 == 0 || blankPos_S2 == 1 || blankPos_S2 == 2 || blankPos_S2 == 3 || blankPos_S2 == 4 || blankPos_S2 == 5) {
				moves_S2.add("down");
			}
			
			for (String move : moves_S1) { //loop through each move in the arraylist of moves for state 1
				char[] node = new char[9]; //initiate new character array to story child node
				System.arraycopy(S1, 0, node, 0, S1.length); //duplicating state1 to new character array 'node'
				//checking the move assigned to 'move' and adjusting the child node 'node' to match the move
				if (move == "right") {
					node[blankPos_S1] = S1[blankPos_S1+1];
					node[blankPos_S1+1] = ' '; 
				}
				else if (move == "left") {
					node[blankPos_S1] = S1[blankPos_S1-1];
					node[blankPos_S1-1] = ' ';
				}
				else if (move == "up") {
					node[blankPos_S1] = S1[blankPos_S1-3];
					node[blankPos_S1-3] = ' ';
				}
				else if (move == "down") {
					node[blankPos_S1] = S1[blankPos_S1+3];
					node[blankPos_S1+3] = ' ';
				}
				
				if ((visited_S1.add(Arrays.toString(node)))) { //checking if the child node has already been visited
					stack_S1.push(node); //pushing the child node to front of stack for state 1 so the traversal stays DFS
					reachables_S1.add(Arrays.toString(node)); //adding the child node to 'reachables' set for state 1 as it is a valid state 
				}
			}
			
			for (String move : moves_S2) { //loop through each move in the arraylist of moves for state 2
				char[] node = new char[9]; //initiate new character array to story child node
				System.arraycopy(S2, 0, node, 0, S2.length); //duplicating state 2 to new character array 'node'
				//checking the move assigned to 'move' and adjusting the child node 'node' to match the move
				if (move == "right") {
					node[blankPos_S2] = S2[blankPos_S2+1];
					node[blankPos_S2+1] = ' '; 
				}
				else if (move == "left") {
					node[blankPos_S2] = S2[blankPos_S2-1];
					node[blankPos_S2-1] = ' ';
				}
				else if (move == "up") {
					node[blankPos_S2] = S2[blankPos_S2-3];
					node[blankPos_S2-3] = ' ';
				}
				else if (move == "down") {
					node[blankPos_S2] = S2[blankPos_S2+3];
					node[blankPos_S2+3] = ' ';
				}
				
				if ((visited_S2.add(Arrays.toString(node)))) { //checking if the child node has already been visited
					stack_S2.push(node); //pushing the child node to front of stack for state 2 so the traversal stays DFS
					reachables_S2.add(Arrays.toString(node)); //adding the child node to 'reachables' set for state 2 as it is a valid state 
				}
			}
		}
		Set<String> reachablesIntersection = new HashSet<String>(); //initialising new set to store the intersection of all 'reachables' from state 1 and 2 inputted
		for (String s : reachables_S1) { //looping through each state in 'reachables' states set from state 1 inputted
			if (reachables_S2.contains(s)) { //check if the state also exists in 'reachables' set from state 2 inputted
				reachablesIntersection.add(s); //adding state which exists in both 'reachables' sets
			}
			
		}
		
		try {
			FileWriter myWriter = new FileWriter("Output.txt", false);
			BufferedWriter bw = new BufferedWriter(myWriter);
			bw.write("State 1: " + Arrays.toString(state1) + "\n");
			bw.write("State 2: " + Arrays.toString(state2) + "\n");
			bw.write("Reachables for State 1. \n");
			for (String s : reachables_S1) { //output contents of 'reachables' for state 1
				bw.write(s + "\n");
			}
			bw.write("Number of reachables for State 1. \n");
			bw.write(reachables_S1.size() + "\n"); //output size of the 'reachables' set for state 1
			bw.write("Reachables for State 2. \n");
			for (String s : reachables_S2) { //output contents of 'reachables' for state 2
				bw.write(s + "\n");
			}
			bw.write("Number of reachables for State 2. \n");
			bw.write(reachables_S2.size() + "\n"); //output size of the 'reachables' set for state 2
			bw.write("Common States in reachables for both inputted states. \n");
			for (String s : reachablesIntersection) { //output contents of the intersection between 'reachables' for state 1 and state 2
				bw.write(s + "\n");
			}
			bw.write("Number of states common in reachables for both inputted states. \n");
			bw.write(reachablesIntersection.size() + "\n"); //output size of the intersection set
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (String s : reachables_S1) { //output contents of 'reachables' for state 1
			System.out.println(s);
		}
		for (String s : reachables_S2) { //output contents of 'reachables' for state 2
			System.out.println(s);
		}
		System.out.println(reachables_S1.size()); //output size of 'reachables' for state 1
		System.out.println(reachables_S2.size()); //output size of 'reachables' for state 1
		System.out.println(reachablesIntersection.size()); //output size of set containing all states which exist in 'reachables' of state 1 and 2
	}

}
