package gameOfLife;

import java.util.Scanner;

public class ConsoleView {

	private IListener listener;

	public void queryToContinue() {
		Scanner input = new Scanner(System.in);
		String advance = "";

		do {
			System.out.println("Advance Y/N?:");
			advance = input.next();
			listener.advance();
		} while (advance.equalsIgnoreCase("y"));
		input.close();

	}

	public void setListener(IListener listener) {
		this.listener = listener;
	}

	public void update(boolean[][] grid) {
		String gridReport = "";
		for (int y = 0; y < grid.length; y++) {
			gridReport += "\n";
			for (int x = 0; x < grid[y].length; x++) {
				if (grid[y][x]) {
					gridReport += "O ";
				} else {
					gridReport += "* ";
				}
			}
		}
		System.out.println(gridReport);
	}

}
