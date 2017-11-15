package new_package.tests;

import new_package.Game;
import new_package.Point;
import new_package.Snake;
import new_package.objects.SnakeBody;
import new_package.objects.SnakeHead;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SnakeTest {
    private int width;
    private int height;
    private Game game;
    private Snake snake;

    private void initSnake(int fieldWidth, int fieldHeight){
        this.width = fieldWidth;
        this.height = fieldHeight;
        this.game = new Game(width, height);
        this.snake = new Snake(game);
    }

    @Test
    void testNewSnake(){
        initSnake(7,7);

        assertEquals(game.getField().getObjectAt(width/2+1, height/2).getClass(), SnakeHead.class);
        assertEquals(game.getField().getObjectAt(width/2,   height/2).getClass(), SnakeBody.class);
        assertEquals(game.getField().getObjectAt(width/2-1, height/2).getClass(), SnakeBody.class);

        assertEquals(snake.getSegments().get(0), new Point(width/2-1, height/2));
        assertEquals(snake.getSegments().get(1), new Point(width/2,   height/2));
        assertEquals(snake.getSegments().get(2), new Point(width/2+1, height/2));

        assertEquals(snake.getDirection(), SnakeHead.DIRECTION_RIGHT);
    }

    @Test
    void testDirectionSetter(){
        initSnake(7,7);
        Point direction = SnakeHead.DIRECTION_UP;
        snake.setDirection(direction);
        assertEquals(snake.getDirection(), direction);
    }

    @Test
    void testCuttingTail(){
        initSnake(5,5);
        int oldSnakeLength = snake.getSegments().size();
        snake.cutTail();
        int snakeLength = snake.getSegments().size();
        assertEquals(1,oldSnakeLength - snakeLength);
        assertEquals(new Point(width/2, height/2), snake.getSegments().get(0));

//        ...
    }
}
