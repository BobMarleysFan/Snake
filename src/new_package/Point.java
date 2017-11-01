package new_package;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object other){
        if(other instanceof Point){
            Point otherPoint = (Point)other;
            return this.x == otherPoint.x && this.y == otherPoint.y;
        }
        else return false;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}