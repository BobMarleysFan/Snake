package new_package;

import new_package.objects.Apple;

import java.util.ArrayList;
import java.util.Random;

public class AppleGenerator {
    private final Field field;

    public AppleGenerator(Field field){
        this.field = field;
    }

    public void placeAppleOnRandomEmptyCell(){
        ArrayList<Point> emptyCells = field.getEmptyCells();
        Random random = new Random();
        Point randomCell = emptyCells.get(random.nextInt(emptyCells.size()));
        field.setObjectAt(randomCell.x, randomCell.y, new Apple());
    }
}
