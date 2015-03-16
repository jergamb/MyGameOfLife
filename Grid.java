
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
				int numNeighbors = numberOfNeighbors(i, j);
				
				// check to see if space is populated or unpopulated
				if (c == '*') {
					if (numNeighbors == 0 || numNeighbors == 1) {
						// cell dies
						tempGrid[i][j] = '.';
					}
					else if (numNeighbors == 2 || numNeighbors == 3) {
						// cell survives
						tempGrid[i][j] = '*';
					}
					else if (numNeighbors >= 4) {
						// cell dies
						tempGrid[i][j] = '.';
					}
				} 
				else {
					if (numNeighbors == 3) {
						// cell is populated
						tempGrid[i][j] = '*';
					}
				}
			}
		}
		
		// now that update the currentGrid with the changes made on tempGrid
		updateCurrentGrid();
	}
	
	/*
	 * Copies tempGrid's changes on to CurrentGrid
	 */
	private void updateCurrentGrid() {
		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows; j++) {
				currentGrid[i][j] = tempGrid[i][j];
			}
		}
	}

	/*
	 * Returns the number of neighbors a populated space has
	 */
	private int numberOfNeighbors(int col, int row) {
		int neighbors = 0;
				
		if (row > 0 && row < 99 && col == 0) {
			assert neighbors == 0;
			char north = currentGrid[col][row-1];
			char south = currentGrid[col][row+1];
			char east = currentGrid[col+1][row];
			char NE = currentGrid[col+1][row-1];
			char SE = currentGrid[col+1][row+1];
			if (north == '*')
				neighbors++;
			if (south == '*')
				neighbors++;
			if (east == '*')
				neighbors++;
			if (NE == '*')
				neighbors++;
			if (SE == '*')
				neighbors++;
			return neighbors;
		}
		if (row > 0 && row < 99 && col == 99) {
			assert neighbors == 0;
			char north = currentGrid[col][row-1];
			char south = currentGrid[col][row+1];
			char west = currentGrid[col-1][row];
			char NW = currentGrid[col-1][row-1];
			char SW = currentGrid[col-1][row+1];
			if (north == '*')
				neighbors++;
			if (south == '*')
				neighbors++;
			if (west == '*')
				neighbors++;
			if (NW == '*')
				neighbors++;
			if (SW == '*')
				neighbors++;
			return neighbors;
		}
		
		if (row == 0 && col > 0 && col < 99) {
			assert neighbors == 0;
			char north = currentGrid[col][99];
			char south = currentGrid[col][row+1];
			char east = currentGrid[col+1][row];
			char west = currentGrid[col-1][row];
			char NW = currentGrid[col-1][99];
			char NE = currentGrid[col+1][99];
			char SW = currentGrid[col-1][row+1];
			char SE = currentGrid[col+1][row+1];
			if (north == '*')
				neighbors++;
			if (south == '*')
				neighbors++;
			if (east == '*')
				neighbors++;
			if (west == '*')
				neighbors++;
			if (NW == '*')
				neighbors++;
			if (NE == '*')
				neighbors++;
			if (SW == '*')
				neighbors++;
			if (SE == '*')
				neighbors++;
			return neighbors;
		}
		if  (row == 99 && col > 0 && col < 99) {
			assert neighbors == 0;
			char north = currentGrid[col][row-1];
			char south = currentGrid[col][0];
			char east = currentGrid[col+1][row];
			char west = currentGrid[col-1][row];
			char NW = currentGrid[col-1][row-1];
			char NE = currentGrid[col+1][row-1];
			char SW = currentGrid[col-1][0];
			char SE = currentGrid[col+1][0];
			if (north == '*')
				neighbors++;
			if (south == '*')
				neighbors++;
			if (east == '*')
				neighbors++;
			if (west == '*')
				neighbors++;
			if (NW == '*')
				neighbors++;
			if (NE == '*')
				neighbors++;
			if (SW == '*')
				neighbors++;
			if (SE == '*')
				neighbors++;
			return neighbors;
		}
		// edge case
		if (row == 0 && col == 0) {
			assert neighbors == 0;
			char north = currentGrid[col][99];
			char south = currentGrid[col][row+1];
			char east = currentGrid[col+1][row];
			char NE = currentGrid[col+1][99];
		    char SE = currentGrid[col+1][row+1]; 
			if (north == '*')
				neighbors++;
			if (south == '*')
				neighbors++;
			if (east == '*')
				neighbors++;
			if (NE == '*')
				neighbors++;
			if (SE == '*')
				neighbors++;
			return neighbors;
		}
		// edge case
		if (row == 0 && col == 99) {
			assert neighbors == 0;
			char north = currentGrid[col][99];
			char south = currentGrid[col][row+1];
			char west = currentGrid[col-1][row];
			char NW = currentGrid[col-1][99];
			char SW = currentGrid[col-1][row+1];
			if (north == '*')
				neighbors++;
			if (south == '*')
				neighbors++;
			if (west == '*')
				neighbors++;
			if (NW == '*')
				neighbors++;
			if (SW == '*')
				neighbors++;
			return neighbors;
		}
		// edge case
		if (row == 99 && col == 0) {
			assert neighbors == 0;
			char north = currentGrid[col][row-1];
			char south = currentGrid[col][0];
			char east = currentGrid[col+1][row];
			char NE = currentGrid[col+1][row-1];
			char SE = currentGrid[col+1][0];		
			if (north == '*')
				neighbors++;
			if (south == '*')
				neighbors++;
			if (east == '*')
				neighbors++;
			if (NE == '*')
				neighbors++;
			if (SE == '*')
				neighbors++;
			return neighbors;
		}
		// edge case
		if (row == 99 && col == 99) {
			assert neighbors == 0;
			char north = currentGrid[col][row-1];
			char south = currentGrid[col][0];
			char west = currentGrid[col-1][row];
			char NW = currentGrid[col-1][row-1];
			char SW = currentGrid[col-1][0];
			if (north == '*')
				neighbors++;
			if (south == '*')
				neighbors++;
			if (west == '*')
				neighbors++;
			if (NW == '*')
				neighbors++;
			if (SW == '*')
				neighbors++;
			return neighbors;
		}
		assert neighbors == 0;
		
		// take care of any normal cases
		char north = currentGrid[col][row-1];
		char south = currentGrid[col][row+1];
		char east = currentGrid[col+1][row];
		char west = currentGrid[col-1][row];
		char NW = currentGrid[col-1][row-1];
		char NE = currentGrid[col+1][row-1];
		char SW = currentGrid[col-1][row+1];
		char SE = currentGrid[col+1][row+1];
		if (north == '*')
			neighbors++;
		if (south == '*')
			neighbors++;
		if (east == '*')
			neighbors++;
		if (west == '*')
			neighbors++;
		if (NW == '*')
			neighbors++;
		if (NE == '*')
			neighbors++;
		if (SW == '*')
			neighbors++;
		if (SE == '*')
			neighbors++;
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
			System.out.print("\n");
		}
		System.out.println();
	}
	
}
 