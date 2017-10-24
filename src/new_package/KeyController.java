package new_package;

import new_package.objects.SnakeHead;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyController extends KeyAdapter {
    final Game game;

    public KeyController(Game game) {
        this.game = game;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Point direction = game.getSnake().getDirection();
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                if (direction != SnakeHead.DIRECTION_DOWN)
                    game.getSnake().setDirection(SnakeHead.DIRECTION_UP);
                break;

            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                if (direction != SnakeHead.DIRECTION_LEFT)
                    game.getSnake().setDirection(SnakeHead.DIRECTION_RIGHT);
                break;

            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                if (direction != SnakeHead.DIRECTION_RIGHT)
                    game.getSnake().setDirection(SnakeHead.DIRECTION_LEFT);
                break;

            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                if (direction != SnakeHead.DIRECTION_UP)
                    game.getSnake().setDirection(SnakeHead.DIRECTION_DOWN);
                break;

            case KeyEvent.VK_ESCAPE:
                game.stopCondition = true;
                break;
        }
    }
}