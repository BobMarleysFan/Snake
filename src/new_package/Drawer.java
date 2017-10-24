package new_package;

import new_package.objects.FieldObject;
import new_package.objects.SnakeBody;
import new_package.objects.SnakeHead;
import new_package.objects.Wall;
import new_package.objects.Apple;

import javax.swing.*;
import java.awt.*;

public class Drawer extends JPanel {
    private Game game;

    public Drawer(Game game) {
        this.game = game;
        setPreferredSize(new Dimension(
                game.getField().getWidth() * game.CellSize,
                game.getField().getHeight() * game.CellSize)
        );
        setBackground(Color.BLACK);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawGrid(g);
        for (int x = 0; x < game.getField().getWidth(); x++){
            for (int y = 0; y < game.getField().getHeight(); y++) {
                FieldObject object = game.getField().getObjectAt(x, y);
                if (object instanceof Wall) {
                    paint_cell(g,x,y, Color.BLACK);
                } else if (object instanceof SnakeBody) {
                    paint_cell(g,x,y,Color.green);
                } else if (object instanceof SnakeHead) {
                    paint_cell(g,x,y,Color.blue);
                } else if (object instanceof Apple) {
                    paint_cell(g,x,y,Color.red);
                }
            }}
        //paint_circle(g, game.snake.getBody().get(0), Color.black);

        if (game.stopCondition) {
            g.setColor(Color.red);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            FontMetrics fm = g.getFontMetrics();
            g.drawString("GAME OVER", (game.getField().getWidth() * game.CellSize - fm.stringWidth("GAME OVER")) / 2,
                    (game.getField().getHeight() * game.CellSize) / 2);
        }
    }

    private void drawGrid(Graphics g) {
        for (int x = 0; x < game.getField().getWidth(); x++) {//Рисуем сетку
            for (int y = 0; y < game.getField().getHeight(); y++) {
                g.setColor(Color.DARK_GRAY);
                g.drawRect(x * game.CellSize, y * game.CellSize,
                        game.CellSize, game.CellSize);
            }
        }
    }

    private void paint_cell(Graphics g, int x, int y, Color color) {
        g.setColor(color);
        g.fillRect(x * game.CellSize, y * game.CellSize,
                game.CellSize, game.CellSize);
        g.setColor(Color.GRAY);
        g.drawRect(x * game.CellSize, y * game.CellSize,
                game.CellSize, game.CellSize);
    }

    private void paint_circle(Graphics g, Point p, Color color) {
        g.setColor(color);
        g.fillArc(p.x * 32, p.y * 32,
                32 / 2, 32 / 2, 0, 360);

    }
}