package new_package.presenters;

import new_package.objects.Apple;
import new_package.objects.FieldObject;

public class ApplePresenter implements Presenter {

    @Override
    public String getFilepath(){return "src/textures/apple.png";}

    @Override
    public FieldObject getObjectByChar() {
        return new Apple();
    }
}
