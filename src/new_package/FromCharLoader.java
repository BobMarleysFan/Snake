package new_package;

import new_package.objects.*;
import new_package.presenters.*;

import java.util.HashMap;

 public class FromCharLoader {
     private Field field;

     public FromCharLoader(Field field){
        this.field = field;
     }

     private static HashMap<Character, FieldObject> map = new HashMap<Character, FieldObject>() {{
        put('x',  WallPresenter.getInstance().getObject());
        put(' ',  EmptyCellPresenter.getInstance().getObject());
        put('S',  SnakeHeadPresenter.getInstance().getObject());
        put('a',  ApplePresenter.getInstance().getObject());
        put('s',  SnakeBodyPresenter.getInstance().getObject());
    }};

     public static HashMap<Character, FieldObject> getMap() {
         return map;
     }
 }
