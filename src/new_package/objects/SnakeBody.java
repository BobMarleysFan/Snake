package new_package.objects;

import new_package.Game;
import new_package.presenters.Presenter;
import new_package.presenters.SnakeBodyPresenter;

public class SnakeBody implements FieldObject{
	private Presenter presenter = new SnakeBodyPresenter();

	public void intersect(Game g){
		g.stopCondition = true;
		System.out.print("Game over");
	}

	@Override
	public Presenter getPresenter() {
		return presenter;
	}
}