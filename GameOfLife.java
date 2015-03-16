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
    	fileName = args[1];
    	
    	char[][] tempTable = null;
    	
    	tempTable = readFromFile(fileName);
    	
    	
    	// initialize the grid
    	grid = new Grid(tempTable);
    	
    	assert grid != null;
    	
    	int currentRound = 0;
    	while (currentRound < numGenerations) {
    		grid.performRound();
    		
    		if (verboseMode)
    			grid.printGrid();
    		
    		// keep track of the rounds by incrementing counter
    		currentRound++;
    	}
    	
    	// finally print out the last updated grid
    	grid.printGrid();
    }

    /*
     * Reads from a file and updates tempTable
     */
	private static char[][] readFromFile(String file) {
		int cols = 100;
		int rows = 100;
		char[][] temp = new char[cols][rows];
		
		assert file != null;
		
		try {
			FileInputStream inputStream = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			String line;
		
			// keep track of row and go through each line of the file
			int colIndex = 0;
			while((line = br.readLine()) != null) {
				for (int i = 0; i < cols; i++) {
					char c = line.charAt(i);
					temp[colIndex][i] = c;
				}
				// increment rowIndex for next row in temp
				colIndex++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return temp;
	}

}
