package new_package;

import new_package.objects.SnakeHead;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyController extends KeyAdapter {
    private final Game game;

    public KeyController(Game game) {
        this.game = game;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                game.getSnake().setNewDirection(SnakeHead.DIRECTION_UP);
                break;

            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                game.getSnake().setNewDirection(SnakeHead.DIRECTION_RIGHT);
                break;

            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                game.getSnake().setNewDirection(SnakeHead.DIRECTION_LEFT);
                break;

            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                game.getSnake().setNewDirection(SnakeHead.DIRECTION_DOWN);
                break;

            case KeyEvent.VK_ESCAPE:
                game.stopCondition = true;
                break;
        }
    }
}