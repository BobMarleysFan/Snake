package new_package;

import new_package.objects.*;

import java.util.ArrayList;

public class Field {
	private int height;
	private int width;
	private FieldObject[][] field;

	public Field(int width, int height){
		field = new FieldObject[width][height];
		for(int i=0; i < width; i++)
			for (int j=0; j < height; j++)
				if (i==0 || i==width-1 || j==0 || j==height-1)
					field[i][j] = new Wall();
				else
					field[i][j] = new EmptyCell();
		this.height = height;
		this.width = width;
	}
	public Field(char[][] level){
		width = level.length;
		height = level[0].length;
        field = new FieldObject[width][height];
        for(int i=0; i < width; i++){
			for (int j=0; j < height; j++){
				field[i][j] = getObjectByChar(level[i][j]);
			}
		}
	}

	private FieldObject getObjectByChar(char c) {
		switch (c){
			case '0':
				return new EmptyCell();
			case 'x':
				return new Wall();
			case 's':
				return new SnakeBody();
			case 'S':
				return new SnakeHead(SnakeHead.DIRECTION_RIGHT);
			case 'a':
				return new Apple();
			default:
				return new EmptyCell();
		}
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public FieldObject getObjectAt(int x, int y) {
		if (x < 0 || x > this.width || y < 0 || y > this.height)
			throw new IndexOutOfBoundsException("");
		return field[x][y];
	}

	public void setObjectAt(int x, int y, FieldObject object) {
		if (x<0 || x > this.width || y<0 || y > this.height)
			throw new IndexOutOfBoundsException();
		this.field[x][y] = object;
	}

	public ArrayList<Point> getEmptyCells(){
		ArrayList<Point> emptyCells = new ArrayList<>();
		for(int x = 0; x < this.getWidth(); x++)
			for (int y = 0; y < this.getHeight(); y++)
				if (this.getObjectAt(x, y) instanceof EmptyCell){
					emptyCells.add(new Point(x, y));
				}
		return emptyCells;
	}
}
