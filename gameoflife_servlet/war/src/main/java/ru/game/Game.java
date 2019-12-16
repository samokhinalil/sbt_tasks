package ru.game;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private Field field;
	private Field previousField;
	private List<Field> states = new ArrayList<>();
	public boolean isGameOver = false;

	public Game(int width, int height) {
		field = new Field(width, height);
	}

	public List<Field> getStates() {
		return states;
	}

	public void start() {
		while (!isGameOver) {
			step();
		}
	}

	public void reset() {
		previousField = null;
		states = new ArrayList<>();
		field = new Field(field.getWidth(), field.getHeight());
		isGameOver = false;
	}

	private void step() {
		Field previousField = field.saveField();
		states.add(previousField);
		field.nextGeneration();
		isGameOver = endGame();
	}

	private boolean endGame() {
		if (containsSimilarField()) return true;
		if (previousField != null && field.isSimilar(previousField)) return true;
		return !field.isAlive();
	}

	private boolean containsSimilarField() {
		for (Field f : states) {
			if (field.isSimilar(f)) return true;
		}
		return false;
	}
}

