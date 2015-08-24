package gameOfLife;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class BiomeTest {

	@Test
	public void testCellStartsDead() throws Exception {
		Biome biome = new Biome(1, 1);

		boolean alive = biome.getCellState(0, 0);
		assertFalse(alive);
	}

	@Test
	public void testAllCellsStartDead() throws Exception {
		Biome biome = new Biome(3, 3);

		assertFalse(biome.getCellState(0, 0));
		assertFalse(biome.getCellState(0, 1));
		assertFalse(biome.getCellState(0, 2));
		assertFalse(biome.getCellState(1, 0));
		assertFalse(biome.getCellState(1, 1));
		assertFalse(biome.getCellState(1, 2));
		assertFalse(biome.getCellState(2, 0));
		assertFalse(biome.getCellState(2, 1));
		assertFalse(biome.getCellState(2, 2));
	}

}
