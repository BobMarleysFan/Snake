package new_package.tests;

import new_package.Game;
import new_package.objects.SnakeHead;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    void changeDirectionTest() {
        Game g = new Game();
        assertEquals(SnakeHead.DIRECTION_RIGHT, g.getSnake().getDirection());
        g.getSnake().setDirection(SnakeHead.DIRECTION_DOWN);
        assertEquals(SnakeHead.DIRECTION_DOWN, g.getSnake().getDirection());
    }
    @Test
    void killSnakeTest(){
        Game g = new Game();
        assertEquals(false, g.stopCondition);
        for(int i = 0; i < g.getField().getWidth()/2; i++)
            g.step();
        assertEquals(true, g.stopCondition);
    }

}