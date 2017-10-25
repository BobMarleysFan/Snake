package new_package;

import java.awt.*;

public class Gui {
    private final Window window;
    private final Drawer drawer;
    private final int cellSize;

    public Gui(Game game){
        this.cellSize = 50;
        window = new Window(game, cellSize);
        drawer = new Drawer(game, cellSize);
    }

    public Gui(Game game, int cellSize){
        this.cellSize = cellSize;
        window = new Window(game, cellSize);
        drawer = new Drawer(game, cellSize);

    }

    public void InitUI(){
        window.getContentPane().add(drawer, BorderLayout.CENTER);
        window.setVisible(true);
    }

    public Drawer getDrawer() {
        return drawer;
    }
}
