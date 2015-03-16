
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
	
	
	/*
	 * Perform the round based on these rules:
	 * 	   For a space that is 'populated':
	 * 			Each cell with one or no neighbors dies, as if by loneliness.
	 * 			Each cell with four or more neighbors dies, as if by overpopulation.
	 * 			Each cell with two or three neighbors survives.
	 * 
	 * 	   For a space that is 'empty' or 'unpopulated'
	 * 			Each cell with three neighbors becomes populated
	 */
	public void performRound() {
		
		// iterate through the entire grid and check each space
		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows; j++) {
				
				char c = currentGrid[i][j];
				// check to see if space is populated or unpopulated
				if (c == '*') {
					
				} 
				else {
					
				}
				
			}
		}
		
	}
	

	/*
	 * Returns the number of neighbors a populated space has
	 */
	public int numberOfNeighbors(int col, int row) {
		
		int neighbors = 0;
		
		if (row == 0 && col == 0) {
			
		}
		
		return neighbors;
	}
	

	/*
	 * Print the currentGrid to the console
	 */
	public void printGrid() {
		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows; j++) {
				char c = currentGrid[i][j];
				System.out.print(c);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
