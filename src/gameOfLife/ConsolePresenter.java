package gameOfLife;

public class ConsolePresenter implements IListener {

	private Biome biome;
	private ConsoleView consoleView;

	public ConsolePresenter(ConsoleView consoleView, Biome biome) {
		this.consoleView = consoleView;
		this.biome = biome;
		consoleView.setListener(this);
		updateView();
	}

	@Override
	public void advance() {
		biome.advanceTick();
		updateView();
	}

	private void updateView() {
		boolean[][] grid = biome.getGrid();
		consoleView.update(grid);
	}

}
