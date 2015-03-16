
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
    	
    	
    	
    	// initialize the grid
    	grid = new Grid();
    	
    	
    	
    	
    }
}
