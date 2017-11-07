package new_package.presenters;

import new_package.objects.FieldObject;
import new_package.objects.SnakeHead;

public class SnakeHeadPresenter implements Presenter{
    @Override
    public String getFilepath(){return "src/textures/snakehead.png";}

    @Override
    public FieldObject getObjectByChar() {
        return new SnakeHead(SnakeHead.DIRECTION_RIGHT);
    }
}
