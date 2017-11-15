package new_package.presenters;

import new_package.objects.FieldObject;
import new_package.objects.SnakeBody;

public class SnakeBodyPresenter implements Presenter{
    @Override
    public String getFilepath(){return "src/textures/snakebody.png";}

    @Override
    public FieldObject getObjectByChar() {
        return new SnakeBody();
    }

    @Override
    public char getCharByObject(){return 's';}
}
