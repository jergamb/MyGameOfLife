
public class Grid {
	
	final int cols = 100;
	final int rows = 100;
	
	char[][] currentGrid;
	char[][] tempGrid;
	
	/*
	 * Constructor to initialize both grids
	 */
	public Grid(char[][] table) {
		currentGrid = new char[cols][rows];
		tempGrid = new char[cols][rows];
		
		// initialize both grids
		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows; j++) {
				char c = table[i][j];
				
				currentGrid[i][j] = c;
				tempGrid[i][j] = c;
			}
		}
	}

}
