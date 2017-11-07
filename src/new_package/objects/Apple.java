package new_package.objects;

import new_package.Game;
import new_package.presenters.ApplePresenter;
import new_package.presenters.Presenter;

public class Apple implements FieldObject {
	private Presenter presenter = new ApplePresenter();

	@Override
	public boolean isWalkable() {
		return true;
	}

	public void intersect(Game g) {
		g.getAppleGenerator().placeAppleOnRandomEmptyCell();
	}

	@Override
	public Presenter getPresenter() {
		return presenter;
	}
}