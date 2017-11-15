package new_package.presenters;

import new_package.objects.FieldObject;
import new_package.objects.SnakeHead;

public class SnakeHeadPresenter implements Presenter{
    private static SnakeHeadPresenter instance;

    @Override
    public String getFilepath(){return "src/textures/snakehead.png";}

    @Override
    public FieldObject getObject() {
        return new SnakeHead(SnakeHead.DIRECTION_RIGHT);
    }

    public static Presenter getInstance() {
        return instance == null ? new SnakeHeadPresenter() : instance;
    }
}
