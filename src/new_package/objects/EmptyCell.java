package new_package.objects;

import new_package.Game;

public class EmptyCell implements FieldObject {
	public boolean isWalkable(){return true;}
	public void intersect(Game g) {
		g.getSnake().cutTail();
	}
}
