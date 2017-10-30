package new_package;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Game g = new Game();
        g.getAppleGenerator().placeAppleOnRandomEmptyCell();
        Gui gui = new Gui(g, 40);
        gui.InitUI();
        while(!g.stopCondition)
        {
            g.step();
            gui.getDrawer().repaint();
        }
    }

}