package new_package.presenters;

import new_package.objects.*;
public interface Presenter {

    default String getFilepath(){return "src/textures/default.png";}
    default FieldObject getObjectByChar(){return new EmptyCell();}
}