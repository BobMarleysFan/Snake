package new_package.presenters;

public class EmptyCellPresenter implements Presenter{
    private static EmptyCellPresenter instance;

    @Override
    public String getFilepath(){return "src/textures/empty.png";}

    public static Presenter getInstance() {
        return instance == null ? new EmptyCellPresenter() : instance;
    }
}
