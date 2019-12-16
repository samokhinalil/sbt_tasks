package ru.game;

import java.util.Arrays;
import java.util.Random;

public class Field {
	private int width;
	private int height;
	private boolean[][] field;
	private Random random = new Random();

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public boolean[][] getField() {
		return field;
	}

	public Field(int width, int height) {
		this.width = width;
		this.height = height;
		field = new boolean[width][height];
		fill();
	}

	private Field(boolean[][] field) {
		this.field = field;
		this.width = field.length;
		this.height = field[0].length;
	}

	private void fill() {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				field[i][j] = random.nextBoolean();
			}
		}
	}

	public Field saveField() {
		boolean[][] newField = new boolean[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (isAlive(i, j)) {
					newField[i][j] = true;
				}
			}
		}
		return new Field(newField);
	}

	public boolean isAlive(int x, int y) {
		return field[x][y] == true;
	}

	public boolean isAlive() {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (isAlive(i, j)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isSimilar(Field other) {
		if (Arrays.deepEquals(field, other.field)) return true;
		return false;
	}

	public int countNeighbours(int x, int y) {
		int i2 = x - 1, i3 = x + 1, j2 = y - 1, j3 = y + 1;
		if (i2 == -1) i2 = field.length - 1;
		if (i3 == (field.length)) i3 = 0;
		if (j2 == -1) j2 = field[x].length - 1;
		if (j3 == (field[x].length)) j3 = 0;
		boolean[] cell = {field[i2][j2], field[i2][y], field[i2][j3], field[x][j2],
				field[x][j3], field[i3][j2], field[i3][y], field[i3][j3]};
		int count = 0;
		for (int i = 0; i < cell.length; i++) {
			if (cell[i] == true) count++;
		}
		return count;
	}

	public Field nextGeneration() {
		int neighbourCount = 0;
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				neighbourCount = countNeighbours(i, j);
				if (neighbourCount == 3 && !isAlive(i, j)) {
					field[i][j] = true;
				}
				if ((neighbourCount < 2 || neighbourCount > 3) && isAlive(i, j)) {
					field[i][j] = false;
				}
			}
		}
		return this;
	}
}
