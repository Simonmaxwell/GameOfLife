package gameOfLife;

public class Biome {
	int sizeY = 0;
	int sizeX = 0;
	private boolean[][] grid;

	public Biome(int sizeY, int sizeX) {
		this.sizeY = sizeY;
		this.sizeX = sizeX;
		this.grid = new boolean[sizeY][sizeX];
	}

	public boolean getCellState(int y, int x) {
		return grid[y][x];
	}

	public void setCellState(int y, int x, boolean cellState) {
		grid[y][x] = cellState;
	}

	public void setRandomState() {
		for (int y = 0; y < sizeY; y++) {
			for (int x = 0; x < sizeX; x++) {
				grid[y][x] = Math.random() > 0.5;
			}
		}
	}

	public void advanceTick() {
		boolean[][] nextGrid;
		nextGrid = new boolean[sizeY][sizeX];
		for (int y = 0; y < sizeY; y++) {
			for (int x = 0; x < sizeX; x++) {
				nextGrid[y][x] = cellSurvives(y, x);
			}
		}
		grid = nextGrid;
	}

	private boolean cellSurvives(int y, int x) {
		int countNeighbors = countNeighbors(y, x);
		if (grid[y][x]) {
			return (countNeighbors >= 2 && countNeighbors <= 3);
		} else {
			return countNeighbors == 3;
		}
	}

	private int countNeighbors(int y, int x) {
		int censusTotal = 0;
		for (int deltaY = -1; deltaY <= 1; deltaY++) {
			for (int deltaX = -1; deltaX <= 1; deltaX++) {
				censusTotal += censusValueAt(y + deltaY, x + deltaX);
			}
		}
		censusTotal -= censusValueAt(y, x);
		return censusTotal;
	}

	private int censusValueAt(int y, int x) {
		if (y < 0 || y >= sizeY || x < 0 || x >= sizeX) {
			return 0;
		}
		if (grid[y][x]) {
			return 1;
		} else {
			return 0;
		}
	}

}
