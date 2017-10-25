package new_package.objects;

import new_package.Game;

public class Wall implements FieldObject{
	@Override
	public String getFilepath(){
		return "src/textures/wall.png";
	}

	public void intersect(Game g) {
		g.stopCondition = true;
		System.out.print("Game over");
	}
}