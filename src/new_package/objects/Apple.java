package new_package.objects;

import new_package.Game;
import org.eclipse.swt.graphics.ImageData;

@PresentedBy
public class Apple implements FieldObject {
	public ImageData getImageData() {return new ImageData("src/textures/apple.png");}

	@Override
	public boolean isWalkable() {
		return true;
	}

	public void intersect(Game g) {
    }
}
