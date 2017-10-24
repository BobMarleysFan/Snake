package new_package;

import java.awt.*;

public class Game {
	public boolean stopCondition = false;
	private Field field;
	private Snake snake;
	public final int CellSize = 70;

	Game(){
		field = new Field(15,15);
		snake = new Snake(this);
	}

	void start() throws InterruptedException {
		Window window = new Window(this);
		Drawer drawer = new Drawer(this);
		window.getContentPane().add(BorderLayout.CENTER, drawer);
		window.setVisible(true);

		while (!stopCondition) {
			try {
				Thread.sleep(100);
				snake.Move();
				drawer.repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public Snake getSnake(){
		return snake;
	}

	public Field getField() {
		return field;
	}
}