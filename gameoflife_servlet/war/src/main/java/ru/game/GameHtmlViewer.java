package ru.game;

import java.util.List;

public class GameHtmlViewer {
	private Game game;

	public GameHtmlViewer(Game game) {
		this.game = game;
	}

	public String getGameHtmlView() {
		StringBuilder result = new StringBuilder();
		if (game.isGameOver) {
			List<Field> states = game.getStates();
			for (Field field : states) {
				result.append(getFieldHtmlView(field));
			}
		}
		return result.toString();
	}

	private String getFieldHtmlView(Field field) {
		StringBuilder temp = new StringBuilder();
		for (int i = 0; i < field.getWidth(); i++) {
			temp.append("<div class=\"line\">");
			for (int j = 0; j < field.getHeight(); j++) {
				if (field.getField()[i][j] == true) {
					temp.append("<div class=\"square-green\"></div>");
				} else {
					temp.append("<div class=\"square\"></div>");
				}
			}
			temp.append("</div>");
		}
		temp.append("<h1>-></h1>");
		return temp.toString();
	}
}
