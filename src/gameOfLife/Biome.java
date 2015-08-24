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

}
