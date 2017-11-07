package new_package;

import new_package.objects.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Drawer extends JPanel {
    private Game game;
    private int cellSize;

    public Drawer(Game game, int cellSize) {
        this.game = game;
        this.cellSize = cellSize;
        setPreferredSize(new Dimension(
                game.getField().getWidth() * cellSize,
                game.getField().getHeight() * cellSize)
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
                try {
                    drawObject(g, x, y, object);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }}

        if (game.stopCondition) {
            g.setColor(Color.red);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            FontMetrics fm = g.getFontMetrics();
            g.drawString("GAME OVER", (game.getField().getWidth() * cellSize - fm.stringWidth("GAME OVER")) / 2,
                    (game.getField().getHeight() * cellSize) / 2);
        }
    }

    /**
     * Рисует сетку, разделяющую клетки игрового поля.
     */
    private void drawGrid(Graphics g) {
        for (int x = 0; x < game.getField().getWidth(); x++) {
            for (int y = 0; y < game.getField().getHeight(); y++) {
                g.setColor(Color.DARK_GRAY);
                g.drawRect(x * cellSize, y * cellSize,
                        cellSize, cellSize);
            }
        }
    }

    private void drawObject(Graphics g, int x, int y, FieldObject object) throws IOException {
        BufferedImage rawImage = ImageIO.read(new File(object.getPresenter().getFilepath()));
        g.drawImage(rawImage, x * cellSize, y * cellSize, cellSize, cellSize, new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });
    }

    private void paintCell(Graphics g, int x, int y, Color color) {
        g.setColor(color);
        g.fillRect(x * cellSize, y * cellSize,
                cellSize, cellSize);
        g.setColor(Color.GRAY);
        g.drawRect(x * cellSize, y * cellSize,
                cellSize, cellSize);
    }

    private void paintCircle(Graphics g, Point p, Color color) {
        g.setColor(color);
        g.fillArc(p.getX() * 32, p.getY() * 32,
                32 / 2, 32 / 2, 0, 360);
    }
}