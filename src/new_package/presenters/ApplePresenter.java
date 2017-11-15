package new_package.presenters;

import new_package.objects.Apple;
import new_package.objects.FieldObject;

public class ApplePresenter implements Presenter {
    private static ApplePresenter instance;

    @Override
    public String getFilepath(){return "src/textures/apple.png";}

    @Override
    public FieldObject getObject() {
        return new Apple();
    }

    public static Presenter getInstance() {
        return instance == null ? new ApplePresenter() : instance;
    }
}
