package ru.sbt.sandbox;

import ru.game.Game;
import ru.game.GameHtmlViewer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GameOfLifeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.write("<html>");
		writer.write("<head><link href=\"style.css\" rel=\"stylesheet\"></head>");
		writer.write("<body>");
		writer.write("<h1>Game Of Life</h1>");
		Game game = new Game(10, 10);
		game.start();
		writer.write(new GameHtmlViewer(game).getGameHtmlView());
		writer.write("</body></html>");
		writer.close();
		System.out.println(">>>>> Served");
	}
}
