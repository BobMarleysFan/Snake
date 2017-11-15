package new_package.tests;

import new_package.Field;
import new_package.Point;
import new_package.objects.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {
    private int width;
    private int height;
    private Field field ;
    private ArrayList<Point> emptyCells;

    private void initField(int width, int height){
        this.width = width;
        this.height = height;
        this.field = new Field(width, height);
        this.emptyCells = new ArrayList<>();
        for(int x=1; x<width-1; x++)
            for(int y=1; y<height-1; y++)
                emptyCells.add(new Point(x,y));
    }

    private void initFieldFromCharMatrix(char[][] matrix){
        this.width = matrix[0].length;
        this.height = matrix.length;
        this.field = new Field(matrix);
        this.emptyCells = new ArrayList<>();
        for(int x=1; x<width-1; x++)
            for(int y=1; y<height-1; y++)
                emptyCells.add(new Point(x,y));
    }

    @Test
    void testNewField(){
        initField(7, 5);

        assertEquals(width, field.getWidth());
        assertEquals(height, field.getHeight());
        for(int x=0; x<width; x++){
            for (int y=0; y<height; y++){
                if(x==0 || x==width-1 || y==0 || y==height-1)
                    assertEquals(Wall.class, field.getObjectAt(x, y).getClass());
                else
                    assertEquals(EmptyCell.class, field.getObjectAt(x, y).getClass());
            }
        }
    }

    @Test
    void testFieldMethods(){
        initField(5,5);

        assertIterableEquals(emptyCells, field.getEmptyCells());

        field.setObjectAt(width-1,height-1, new SnakeBody());
        assertEquals(SnakeBody.class, field.getObjectAt(width-1, height-1).getClass());

        assertThrows(IndexOutOfBoundsException.class, ()->field.getObjectAt(width, height));
        assertThrows(IndexOutOfBoundsException.class, ()->field.setObjectAt(width, height, new Wall()));
    }

    @Test
    void testFieldFromCharMatrix(){
        char[][] charLevel = {
                {'x','x','x','x','x'},
                {'x','x','x','x','x'},
                {' ',' ',' ',' ',' '},
                {'a','s','S','x',' '}};
        initFieldFromCharMatrix(charLevel);

        assertEquals(width, field.getWidth());
        assertEquals(height, field.getHeight());
        for(int x=0; x<width; x++){
            for (int y=0; y<height; y++){
                if(y<2)
                    assertEquals(Wall.class, field.getObjectAt(x, y).getClass());
                else if(y==2)
                    assertEquals(EmptyCell.class, field.getObjectAt(x, y).getClass());
                else {
                    if(x==0)
                        assertEquals(Apple.class, field.getObjectAt(x, y).getClass());
                    if(x==1)
                        assertEquals(SnakeBody.class, field.getObjectAt(x, y).getClass());
                    if(x==2)
                        assertEquals(SnakeHead.class, field.getObjectAt(x, y).getClass());
                    if(x==3)
                        assertEquals(Wall.class, field.getObjectAt(x, y).getClass());
                    if(x==4)
                        assertEquals(EmptyCell.class, field.getObjectAt(x, y).getClass());
                }
            }
        }
    }
}