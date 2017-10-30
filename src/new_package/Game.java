package new_package;

import new_package.objects.SnakeHead;

public class Game {
	public boolean stopCondition = false;
	private Field field;
	private Snake snake;
	private AppleGenerator appleGenerator;
	private Point newDirection;

	public Game(){
		field = new Field(20,20);
		snake = new Snake(this);
		appleGenerator = new AppleGenerator(this.field);
		newDirection = SnakeHead.DIRECTION_RIGHT;
	}

	public void step(){
		try {
			Thread.sleep(200);
			snake.setDirection(newDirection);
			snake.Move();
		} catch (InterruptedException e) {
			e.printStackTrace();
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