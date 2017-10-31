package new_package;


public class Main {
    public static char[][] level1 ={{'x','x','x','x','x','x','x','x','x'},
                                    {'x','0','0','0','0','0','0','0','x'},
                                    {'x','0','0','0','0','0','0','0','x'},
                                    {'x','0','0','0','0','0','0','0','x'},
                                    {'x','0','x','x','x','x','x','x','x'},
                                    {'x','0','0','0','0','0','0','0','x'},
                                    {'x','0','0','0','0','0','0','0','x'},
                                    {'x','0','0','0','0','0','0','0','x'},
                                    {'x','x','x','x','x','x','x','x','x'},
                                    {'x','0','0','0','0','0','0','0','x'},
                                    {'x','0','0','0','0','0','0','0','x'},
                                    {'x','0','0','0','0','0','0','0','x'},
                                    {'x','x','x','0','x','x','x','x','x'},
                                    {'x','0','0','0','0','0','0','0','x'},
                                    {'x','0','0','0','0','0','0','0','x'},
                                    {'x','0','0','0','0','0','0','0','x'},
                                    {'x','0','0','0','0','0','0','0','x'},
                                    {'x','0','0','0','0','0','0','0','x'},
                                    {'x','x','x','x','x','x','x','x','x'}};


    public static void main(String[] args) throws InterruptedException {
        Game g = new Game(level1);
        Gui gui = new Gui(g, 40);
        gui.InitUI();
        while(!g.stopCondition)
        {
            g.step();
            gui.getDrawer().repaint();
        }
    }

}

//{{'0','0','0','0'},{}{}{}};
