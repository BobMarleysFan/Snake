package new_package.presenters;

import new_package.objects.FieldObject;
import new_package.objects.Wall;

public class WallPresenter implements Presenter{
    @Override
    public String getFilepath(){return "src/textures/wall.png";}

    @Override
    public FieldObject getObjectByChar() {
        return new Wall();
    }

    @Override
    public char getCharByObject(){return 'x';}
}
