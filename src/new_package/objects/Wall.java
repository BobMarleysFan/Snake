package new_package.objects;

import new_package.Game;
import org.eclipse.swt.graphics.ImageData;

public class Wall implements FieldObject{
	@Override
	public ImageData getImageData(){
		return new ImageData("src/textures/wall.png");
	}

	public void intersect(Game g) {
		g.stopCondition = true;
		System.out.print("Game over");
	}
}

