package new_package.presenters;

import new_package.objects.FieldObject;
import new_package.objects.SnakeBody;

public class SnakeBodyPresenter implements Presenter{
    private static SnakeBodyPresenter instance;

    @Override
    public String getFilepath(){return "src/textures/snakebody.png";}

    @Override
    public FieldObject getObject() {
        return new SnakeBody();
    }

    public static Presenter getInstance() {
        return instance == null ? new SnakeBodyPresenter() : instance;
    }
}
