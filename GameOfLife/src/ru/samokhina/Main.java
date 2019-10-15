package ru.samokhina;

import java.util.Arrays;
import java.util.Random;

public class Main {

	public final static char ALIVE_CELL = '*';
	public final static char EMPTY_CELL = '-';
	public static int width = 5;
	public static int height = 5;
	public static int aliveCellsCount = 15;
	public static boolean isGameOver = false;

	public static void main(String[] args) {
		int[][] field = createField(width, height, aliveCellsCount);
		printField(field, ALIVE_CELL, EMPTY_CELL);

		while (!isGameOver) {
			step(field);
			printField(field, ALIVE_CELL, EMPTY_CELL);
		}
	}

	public static int[][] createField(int width, int height, int aliveCellsCount) {
		int[][] field = new int[width][height];

		Random random = new Random();
		for (int i = 0; i < aliveCellsCount; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			field[x][y] = 1;
		}

		return field;
	}

	public static void printField(int[][] field, char aliveCell, char emptyCell) {
		System.out.println(getFieldView(field, aliveCell, emptyCell));
	}

	public static String getFieldView(int[][] field, char aliveCell, char emptyCell) {
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				if (isAlive(field, i, j)) {
					result.append(aliveCell);
				} else {
					result.append(emptyCell);
				}
			}
			result.append('\n');
		}

		return result.toString();
	}

	public static void step(int[][] field) {
		int[][] previousField = saveField(field);
		int neighbourCount;

		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				neighbourCount = countNeighbourAliveCells(field, i, j);

				if (neighbourCount == 3 && !isAlive(field, i, j)) {
					field[i][j] = 1;
				}
				if ((neighbourCount < 2 || neighbourCount > 3) && isAlive(field, i, j)) {
					field[i][j] = 0;
				}
			}
		}

		isGameOver = endGame(field, previousField);
	}

	public static boolean endGame(int[][] field, int[][] previousField) {
		if (Arrays.deepEquals(field, previousField)) return true;
		return !isAlive(field);
	}

	public static int[][] saveField(int[][] field) {
		int[][] newField = new int[field[0].length][field.length];

		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				if (isAlive(field, i, j)) {
					newField[i][j] = 1;
				}
			}
		}

		return newField;
	}

	public static boolean isAlive(int[][] field, int x, int y) {
		return field[x][y] == 1;
	}

	public static boolean isAlive(int[][] field) {
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				if (isAlive(field, i, j)) {
					return true;
				}
			}
		}
		return false;
	}

	public static int countNeighbourAliveCells(int[][] field, int x, int y) {

		int width = field[0].length;
		int height = field.length;
		int count = 0;
		int[][] neighboursPoints = new int[8][2];

		int index = 0;
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				if (i == x && j == y) {
					continue;
				}
				neighboursPoints[index][0] = i;
				neighboursPoints[index][1] = j;
				index++;
			}
		}

		int otherX, otherY;
		for (int i = 0; i < 8; i++) {
			otherX = neighboursPoints[i][0];
			otherY = neighboursPoints[i][1];

			if (otherX < 0 || otherY < 0) {
				continue;
			}
			if (otherX >= width || otherY >= height) {
				continue;
			}

			if (isAlive(field, otherX, otherY)) {
				count++;
			}
		}

		return count;
	}
}
