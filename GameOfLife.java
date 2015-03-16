import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class GameOfLife {
	
	static Grid grid = null;
	
	static boolean verboseMode = false;
	static int numGenerations = 0;
	static String fileName = null;
	
	
    public static void main(String[] args) {
    	if (args.length < 2) {
    		System.err.println("Invalid number of arguments. Enter number-of-generations and input-file.");
    		System.exit(1);
    	}
    	
    	// check for verbose mode to print after every generation
    	if (args.length == 3) {
    		String verbose = args[2];
    		if (verbose.equals("-v")) {
    			verboseMode = true;
    		}
    	}
    	
    	numGenerations = Integer.parseInt(args[0]);
    	System.out.println("numGenerations is :" + numGenerations);
    	fileName = args[1];
    	
    	// create a readFromFile method to update/return char[][] and also have a try catch around every
    	// then pass in the char[][] to the grid constructor
    	char[][] tempTable = null;
    	
    	tempTable = readFromFile(fileName);
    	
    	// initialize the grid
    	grid = new Grid(tempTable);
    
    	int currentRound = 0;
    	while (currentRound != numGenerations) {
    		
    		grid.performRound();
    		
    		if (verboseMode)
    			grid.printGrid();
    		
    		currentRound++;
    	}
    }

    /*
     * Reads from a file and updates tempTable
     */
	private static char[][] readFromFile(String file) {
		int cols = 100;
		int rows = 100;
		char[][] temp = new char[cols][rows];
		
		try {
			FileInputStream inputStream = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			String line;
		
			// keep track of row and go through each line of the file
			int rowIndex = 0;
			while((line = br.readLine()) != null) {
				for (int i = 0; i < cols; i++) {
					char c = line.charAt(i);
					temp[i][rowIndex] = c;
				}
				// increment rowIndex for next row in temp
				rowIndex++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return temp;
	}

}

