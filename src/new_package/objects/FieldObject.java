package new_package.objects;

import new_package.Game;
import new_package.presenters.Presenter;

public interface FieldObject {
	default boolean isWalkable(){ return false; }
	void intersect(Game g);
	Presenter getPresenter();
}