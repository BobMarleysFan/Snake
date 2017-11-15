package new_package;


public class Game {
	private int STEP_INTERVAL_IN_MILLIS = 400;

	public boolean stopCondition = false;
	private Field field;
	private Snake snake;
	private AppleGenerator appleGenerator;

	public Game(){
		this(20, 20);
	}

	public Game(int width, int height){
		field = new Field(height, width);
		snake = new Snake(this);
		appleGenerator = new AppleGenerator(field);
		appleGenerator.placeAppleOnRandomEmptyCell();
	}

	public Game(char[][] level){
		field = new Field(level);
		snake = new Snake(this);
		appleGenerator = new AppleGenerator(field);
		appleGenerator.placeAppleOnRandomEmptyCell();
	}

	public void step(){
		try {
			Thread.sleep(STEP_INTERVAL_IN_MILLIS);
			snake.move();
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

	public AppleGenerator getAppleGenerator() {
		return appleGenerator;
	}
}