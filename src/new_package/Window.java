package new_package;


import javax.swing.*;

public class Window extends JFrame {
    public final int HEADER_HEIGHT = 29;

    public Window(Game game, int cellSize) {
        super("Snake");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(game.getField().getWidth() * cellSize,
                game.getField().getHeight() * cellSize + HEADER_HEIGHT);

        setLocation(100, 100);
        setResizable(false);
        addKeyListener(new KeyController(game));
    }
}