package new_package.objects;

import new_package.Game;
import new_package.presenters.Presenter;
import new_package.presenters.WallPresenter;

public class Wall implements FieldObject{
	private Presenter presenter = new WallPresenter();

	public void intersect(Game g) {
		g.stopCondition = true;
		System.out.print("Game over");
	}

	@Override
	public Presenter getPresenter() {
		return presenter;
	}
}