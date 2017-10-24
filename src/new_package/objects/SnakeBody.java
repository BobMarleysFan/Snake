package new_package.objects;

import new_package.Game;
import org.eclipse.swt.graphics.ImageData;

public class SnakeBody implements FieldObject{
	@Override
	public ImageData getImageData() {
		return new ImageData("src/textures/snakebody.png");
	}

	public void intersect(Game g){
		g.stopCondition = true;
		System.out.print("Game over");
	}
}
