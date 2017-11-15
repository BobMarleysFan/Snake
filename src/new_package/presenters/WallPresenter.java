package new_package.presenters;

import new_package.objects.FieldObject;
import new_package.objects.Wall;

public class WallPresenter implements Presenter{
    private static WallPresenter instance;

    @Override
    public String getFilepath(){return "src/textures/wall.png";}

    @Override
    public FieldObject getObject() {
        return new Wall();
    }

    public static Presenter getInstance() {
        return instance == null ? new WallPresenter() : instance;
    }
}
