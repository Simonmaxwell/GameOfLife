package gameOfLife;

import java.util.Scanner;

public class GameOfLife {
	private static final int SIZE_Y = 5;
	private static final int SIZE_X = 5;
	private static Biome biome;

	public static void main(String[] args) {
		biome = new Biome(SIZE_Y, SIZE_X);
		queryUserToContinue();
	}

	public static void queryUserToContinue() {
		Scanner input = new Scanner(System.in);
		String advance = "";

		do {
			System.out.println(censusReport());
			System.out.println("Advance Y/N?:");
			advance = input.next();
			biome.advanceTick();
		} while (advance.equalsIgnoreCase("y"));
		input.close();
	}

	public static String censusReport() {
		String gridReport = "";
		for (int y = 0; y < SIZE_Y; y++) {
			gridReport += "\n";
			for (int x = 0; x < SIZE_X; x++) {
				boolean alive = biome.getCellState(y, x);
				if (alive) {
					gridReport += "O ";
				} else {
					gridReport += "* ";
				}
			}
		}
		return gridReport;
	}

}
