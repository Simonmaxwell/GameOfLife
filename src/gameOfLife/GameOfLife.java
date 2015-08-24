package gameOfLife;

public class GameOfLife {
	private static final int SIZE_Y = 20;
	private static final int SIZE_X = 20;
	private static Biome biome;

	public static void main(String[] args) {
		biome = new Biome(SIZE_Y, SIZE_X);
		biome.setRandomState();

		ConsoleView consoleView = new ConsoleView();
		new ConsolePresenter(consoleView, biome);
		consoleView.queryToContinue();
	}

}
