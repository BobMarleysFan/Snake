package new_package.objects;

import new_package.Game;

public class EmptyCell implements FieldObject {
	public boolean isWalkable(){return true;}

	@Override
	public String getFilepath() {
		return "src/textures/empty.png";
	}

	public void intersect(Game g) {
		g.getSnake().cutTail();
	}
}