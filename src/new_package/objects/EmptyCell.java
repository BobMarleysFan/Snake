package new_package.objects;

import new_package.Game;
import new_package.presenters.EmptyCellPresenter;
import new_package.presenters.Presenter;

public class EmptyCell implements FieldObject {
    private Presenter presenter = new EmptyCellPresenter();
	public boolean isWalkable(){return true;}
	public void intersect(Game g) {
		g.getSnake().cutTail();
	}

	@Override
	public Presenter getPresenter() {
		return presenter;
	}
}