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

    public void Move() {
        int oldX = this.snake.get(snake.size()-1).x;
        int oldY = this.snake.get(snake.size()-1).y;
        int newX = oldX + this.head.getDirection().x;
        int newY = oldY+ this.head.getDirection().y;
        Point tail = snake.get(0);
        if(tail.x==newX && tail.y==newY){
            game.getField().setObjectAt(oldX, oldY, new SnakeBody());
            game.getField().setObjectAt(newX, newY, head);
            snake.add(new Point(newX, newY));
            snake.remove(0);
            return;
        }
        FieldObject intersectingObject = game.getField().getObjectAt(newX, newY);
        if(intersectingObject.isWalkable()) {
            game.getField().setObjectAt(oldX, oldY, new SnakeBody());
            game.getField().setObjectAt(newX, newY, head);
            snake.add(new Point(newX, newY));
        }
        intersectingObject.intersect(game);
    }

    public void cutTail() {
        Point tail = snake.get(0);
        snake.remove(0);
        game.getField().setObjectAt(tail.x, tail.y, new EmptyCell());
    }

    public void setDirection(Point dir){
        head.setDirection(dir);
    }

    public Point getDirection(){
        return head.getDirection();
    }
}
