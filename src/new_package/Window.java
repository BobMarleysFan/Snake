package new_package;


import javax.swing.*;

public class Window extends JFrame {
    public Window(Game game) {
        super("SnakeGame");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(game.getField().getWidth() * game.CellSize , //+ 218
                game.getField().getHeight() * game.CellSize );//+ 40
        setLocation(200, 100);
        setResizable(false);
        addKeyListener(new KeyController(game));
    }
}

