package new_package.objects;

import new_package.Game;
import org.eclipse.swt.graphics.ImageData;

public interface FieldObject {
	default boolean isWalkable(){ return false; }
	void intersect(Game g);
	default ImageData getImageData(){return new ImageData("src/textures/default.png");}
}
