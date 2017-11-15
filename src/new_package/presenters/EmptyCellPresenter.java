package new_package.presenters;

import new_package.objects.EmptyCell;
import new_package.objects.FieldObject;

public class EmptyCellPresenter implements Presenter{
    @Override
    public String getFilepath(){return "src/textures/empty.png";}
    @Override
    public char getCharByObject(){
        return ' ';
    }
}
