package new_package;


import javax.swing.*;

public class Window extends JFrame {
    public Window(Game game, int cellSize) {
        super("SnakeGame");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(game.getField().getWidth() * cellSize + 7, //+ 218
                game.getField().getHeight() * cellSize + 28);//+ 40

        setLocation(100, 100);
        setResizable(false);
        addKeyListener(new KeyController(game));
    }
}