import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class General {
	private static General theGeneral = null;
	
	public static ArrayList<Integer> goal = new ArrayList<Integer>(); // This arraylist will contain the goal coordinates
	public static ArrayList<Integer> start = new ArrayList<Integer>(); // This arrayList will contain the start coordinates
	public static char[][] matrix = new char[1][1];  // matrix which we will use to simulate the maze with chars
	public static int col, row; // public static vars for the methods in the program
	
	//Singleton method in order to be able to use all the public vars we declared here
	public static General getInstance() {
		if(theGeneral==null)
			theGeneral = new General();
		return theGeneral;		
	}
	
	// This method will get a filename ("maze1") and will find the goal location, the start location and will convert the maze to our a Char matrix.
	public char[][] readFileByName (String fileName) {
		try {
			// Read input file
	        Scanner input = new Scanner(new File(fileName));  // scanner to the read the text file
	        
	        while (input.hasNext()) {
	            // This should be here to get size of array before getting each array
	            col = input.nextInt();
	            row = input.nextInt();           
	            char[][] a = new char[(row*2)+1][(col*2)+1];
	            
	            String str = input.nextLine();
	            for (int i=0; i<(row*2)+1; i++) {
	            	str = input.nextLine();
	                for (int j=0; j<(col*2)+1; j++) {
	                	if (str.charAt(j) == 'X') {  // Goal location
	                		goal.add(i);
	                		goal.add(j);
	                	}
	                	if (str.charAt(j) == '*') {  // Start location
	                		start.add(i);
	                		start.add(j);
	                	}
	                	a[i][j] = str.charAt(j);  // the maze itself
	                }
	            }
	            matrix = a;
	            //print the input matrix
	            System.out.println("The input sorted matrix is : ");
	            for (int i=0; i<(row*2)+1; i++) {
	                for (int j=0; j<(col*2)+1; j++) {
	                    System.out.printf("%2s", a[i][j]);
	                }
	                System.out.println();
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
		return matrix;
	}
	
	// This method gets the state location (i,j) in the maze and will return the next set of moves the algorithm can make
	public ArrayList<Cell> successor (int i, int j) {
		ArrayList<Cell> arr = new ArrayList<Cell>();
		
		//for direction: up=1, right=2, down=3, left=4
		if ((i-2)>0 && matrix[i-1][j]==' ') {  //making sure we stay in bounds and that we do not have any wall
			arr.add(new Cell(i-2, j, 1, calcHeuristic(i-2, j)));
		}
		if ((j+2)<(col*2) && matrix[i][j+1]==' ') {  //making sure we stay in bounds and that we do not have any wall
			arr.add(new Cell(i, j+2, 2, calcHeuristic(i, j+2)));
		}
		if ((i+2)<(row*2) && matrix[i+1][j]==' ') {  //making sure we stay in bounds and that we do not have any wall
			arr.add(new Cell(i+2, j, 3, calcHeuristic(i+2, j)));
		}
		if ((j-2)>0 && matrix[i][j-1]==' ') {  //making sure we stay in bounds and that we do not have any wall
			arr.add(new Cell(i, j-2, 4, calcHeuristic(i, j-2)));
		}

		return arr;
	}
	
	// this method get a state location and return the heuristic of the specific state from the goal
	public int calcHeuristic (int i, int j) {
		int goalI = goal.get(0)/2;
		int goalJ = goal.get(1)/2;
		int realI = i/2;
		int realJ = j/2;
		
		int res = Math.abs(realI-goalI) + Math.abs(realJ-goalJ);
		return res;
	}
	
	// this method gets state location and goal location and check if the algorithm arrived to the goal state, if so returns true, else false
	public boolean goalTest (int x, int y, int goalRow, int goalCol) {
		if (x==goalRow && y==goalCol) {
			return true;
		}
		return false;
	}

}