package gameOfLife;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

	@Test
	public void testSetCellStateTrueMakesCellLive() {
		Biome biome = new Biome(1, 1);

		biome.setCellState(0, 0, true);

		assertTrue(biome.getCellState(0, 0));
	}

	@Test
	public void testSetAliveFalseMakesCellDead() {
		Biome biome = new Biome(1, 1);
		biome.setCellState(0, 0, true);
		biome.setCellState(0, 0, false);

		assertFalse(biome.getCellState(0, 0));
	}

	@Test
	public void testMoreThanOneCellCanBeAlive() throws Exception {
		Biome biome = new Biome(2, 2);
		biome.setCellState(0, 0, true);
		biome.setCellState(0, 1, true);

		assertTrue(biome.getCellState(0, 0));
		assertTrue(biome.getCellState(0, 1));
	}

	@Test
	public void testCellStateIsSeparateForCoordinates() throws Exception {
		Biome biome = new Biome(2, 2);
		biome.setCellState(0, 0, true);
		biome.setCellState(0, 1, true);
		biome.setCellState(0, 0, false);

		assertFalse(biome.getCellState(0, 0));
		assertTrue(biome.getCellState(0, 1));
	}

	@Test
	public void testLiveCellWithZeroNeighborsDies() throws Exception {
		Biome biome = new Biome(3, 3);
		biome.setCellState(1, 1, true);

		biome.advanceTick();

		assertFalse(biome.getCellState(1, 1));
	}

	@Test
	public void testLiveCellWithOneNeighborDies() throws Exception {
		Biome biome = new Biome(3, 3);
		biome.setCellState(1, 1, true);
		biome.setCellState(1, 2, true);

		biome.advanceTick();

		assertFalse(biome.getCellState(0, 0));
	}

	@Test
	public void testLiveCellWithTwoNeighborsLives() throws Exception {
		Biome biome = new Biome(3, 3);
		biome.setCellState(1, 0, true);
		biome.setCellState(1, 1, true);
		biome.setCellState(1, 2, true);

		biome.advanceTick();

		assertTrue(biome.getCellState(1, 1));
	}

	@Test
	public void testLiveCellWithThreeNeighborsLives() {
		Biome biome = new Biome(3, 3);
		biome.setCellState(1, 1, true);
		biome.setCellState(1, 2, true);
		biome.setCellState(2, 1, true);
		biome.setCellState(2, 2, true);

		biome.advanceTick();

		assertTrue(biome.getCellState(1, 1));
	}

	@Test
	public void testLiveCellWithFourNeighborsDies() throws Exception {
		Biome biome = new Biome(3, 3);
		biome.setCellState(1, 0, true);
		biome.setCellState(1, 1, true);
		biome.setCellState(1, 2, true);
		biome.setCellState(2, 0, true);
		biome.setCellState(2, 1, true);

		biome.advanceTick();

		assertFalse(biome.getCellState(1, 1));
	}

	@Test
	public void testLiveCellWithEightNeighborsDies() throws Exception {
		Biome biome = new Biome(3, 3);
		biome.setCellState(0, 0, true);
		biome.setCellState(0, 1, true);
		biome.setCellState(0, 2, true);
		biome.setCellState(1, 0, true);
		biome.setCellState(1, 1, true);
		biome.setCellState(1, 2, true);
		biome.setCellState(2, 0, true);
		biome.setCellState(2, 1, true);
		biome.setCellState(2, 2, true);

		biome.advanceTick();

		assertFalse(biome.getCellState(1, 1));
	}

	@Test
	public void testDeadCellWithThreeNeighborsLives() throws Exception {
		Biome biome = new Biome(3, 3);
		biome.setCellState(0, 0, true);
		biome.setCellState(0, 1, true);
		biome.setCellState(0, 2, true);

		biome.advanceTick();

		assertTrue(biome.getCellState(1, 1));
	}

	@Test
	public void testDeadCellWithTwoNeighborsRemainsDead() throws Exception {
		Biome biome = new Biome(3, 3);
		biome.setCellState(0, 0, true);
		biome.setCellState(0, 1, true);

		biome.advanceTick();

		assertFalse(biome.getCellState(1, 1));
	}

}