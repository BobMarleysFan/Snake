package new_package;

import new_package.objects.Apple;
import new_package.objects.EmptyCell;
import new_package.objects.FieldObject;
import new_package.objects.Wall;

class Field {
	private int height;
	private int width;
	private FieldObject[][] field;


	Field(int width, int height){
		field = new FieldObject[width][height];
		for(int i=0; i < width; i++)
			for (int j=0; j < height; j++)
				if (i==0 || i==width-1 || j==0 || j==height-1)
					field[i][j] = new Wall();
				else
					field[i][j] = new EmptyCell();
		field[5][9] = new Apple();
		this.height = height;
		this.width = width;
	}
	
	int getHeight() {
		return height;
	}
	
	int getWidth() {
		return width;
	}
	
	FieldObject getObjectAt(int x, int y) {
		if (x < 0 || x > this.width || y < 0 || y > this.height)
			throw new IndexOutOfBoundsException("");
		return field[x][y];
	}
	
	void setObjectAt(int x, int y, FieldObject object) {
		if (x<0 || x > this.width || y<0 || y > this.height)
			throw new IndexOutOfBoundsException();
		this.field[x][y] = object;
	}
}
