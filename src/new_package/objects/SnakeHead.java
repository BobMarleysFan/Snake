package new_package.objects;

import new_package.Game;
import new_package.Point;
import new_package.presenters.Presenter;
import new_package.presenters.SnakeHeadPresenter;

public class SnakeHead implements FieldObject{
	public static Point DIRECTION_UP = new Point(0, -1);
	public static Point DIRECTION_DOWN = new Point(0, 1);
	public static Point DIRECTION_LEFT = new Point(-1, 0);
	public static Point DIRECTION_RIGHT = new Point(1, 0);
	private Point direction;
	private Presenter presenter = new SnakeHeadPresenter();

	public void setDirection(Point dir) {
		if (!(direction.getX() * dir.getX() == -1 || direction.getY() * dir.getY() == -1))
			direction = dir;
	}

	public SnakeHead(){direction = DIRECTION_RIGHT;}
	public SnakeHead(Point dir){
		direction = dir;
	}

	public Point getDirection() {
		return direction;
	}

	public void intersect(Game g) {
		g.stopCondition = true;
		System.out.print("Game over");
	}

	@Override
	public Presenter getPresenter() {
		return presenter;
	}
}