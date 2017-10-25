package new_package.objects;

import new_package.Game;

public interface FieldObject {
	default boolean isWalkable(){ return false; }
	void intersect(Game g);
	default String getFilepath(){return "src/textures/default.png";}
}