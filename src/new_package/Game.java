package new_package;

import new_package.objects.SnakeHead;

public class Game {
	public boolean stopCondition = false;
	private Field field;
	private Snake snake;
	public Gui gui;
	private AppleGenerator appleGenerator;
	private Point newDirection;

	public Game(){
		field = new Field(15,15);
		snake = new Snake(this);
		gui = new Gui(this);
		appleGenerator = new AppleGenerator(this.field);
		newDirection = SnakeHead.DIRECTION_RIGHT;
	}

	void start() throws InterruptedException {
		gui.InitUI();
		getAppleGenerator().placeAppleOnRandomEmptyCell();
		while (!stopCondition) {
			try {
				Thread.sleep(200);
				snake.setDirection(newDirection);
				snake.Move();
				gui.getDrawer().repaint();
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

	public void setNewDirection(Point newDirection) {
		this.newDirection = newDirection;
	}

	public AppleGenerator getAppleGenerator() {
		return appleGenerator;
	}
}