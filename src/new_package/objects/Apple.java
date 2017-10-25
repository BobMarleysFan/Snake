package new_package.objects;

import new_package.Game;

public class Apple implements FieldObject {
	@Override
	public String getFilepath() {return "src/textures/apple.png";}

	@Override
	public boolean isWalkable() {
		return true;
	}

	public void intersect(Game g) {
		g.getAppleGenerator().placeAppleOnRandomEmptyCell();
	}
}