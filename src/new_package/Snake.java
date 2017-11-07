package new_package;

import new_package.objects.EmptyCell;
import new_package.objects.FieldObject;
import new_package.objects.SnakeBody;
import new_package.objects.SnakeHead;

import java.util.ArrayList;

public class Snake {
    private ArrayList<Point> snake;
    private Game game;
    private SnakeHead head;
    private Point newDirection;

    public Snake(Game game){
        this.game = game;
        snake = new ArrayList<Point>();
        snake.add(new Point(this.game.getField().getWidth()/2-1, this.game.getField().getHeight()/2));
        snake.add(new Point(this.game.getField().getWidth()/2, this.game.getField().getHeight()/2));
        snake.add(new Point(this.game.getField().getWidth()/2+1, this.game.getField().getHeight()/2));
        head = new SnakeHead(SnakeHead.DIRECTION_RIGHT);
        this.game.getField().setObjectAt(this.game.getField().getWidth()/2-1, this.game.getField().getHeight()/2, new SnakeBody());
        this.game.getField().setObjectAt(this.game.getField().getWidth()/2, this.game.getField().getHeight()/2, new SnakeBody());
        this.game.getField().setObjectAt(this.game.getField().getWidth()/2+1, this.game.getField().getHeight()/2, head);
    }

    public void move() {
        if(newDirection != null)
            setDirection(newDirection);

        Point headPos = snake.get(snake.size() - 1);
        Point newHeadPos = new Point(
                headPos.getX() + getDirection().getX(),
                headPos.getY() + getDirection().getY()
        );
        Point tailPos = snake.get(0);

        if(tailPos.equals(newHeadPos)){
            moveSnake(headPos, newHeadPos);
            snake.remove(0);
            return;
        }

        FieldObject intersectingObject = game.getField().getObjectAt(newHeadPos.getX(), newHeadPos.getY());
        if(intersectingObject.isWalkable())
            moveSnake(headPos, newHeadPos);
        intersectingObject.intersect(game);
    }

    public void cutTail() {
        Point tail = snake.get(0);
        snake.remove(0);
        game.getField().setObjectAt(tail.getX(), tail.getY(), new EmptyCell());
    }

    public void setDirection(Point dir){
        head.setDirection(dir);
    }

    public Point getDirection(){
        return head.getDirection();
    }

    public void setNewDirection(Point newDirection) {
        this.newDirection = newDirection;
    }

    private void moveSnake(Point headPos, Point newHeadPos){
        game.getField().setObjectAt(headPos.getX(), headPos.getY(), new SnakeBody());
        game.getField().setObjectAt(newHeadPos.getX(), newHeadPos.getY(), head);
        snake.add(new Point(newHeadPos.getX(), newHeadPos.getY()));
    }
}
