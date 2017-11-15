package new_package;

import new_package.objects.*;

import java.util.HashMap;

 public class FromCharLoader {
     private static HashMap<Character, FieldObject> map = new HashMap<Character, FieldObject>() {{
        put('x',  new Wall());
        put(' ',  new EmptyCell());
        put('S',  new SnakeHead());
        put('a',  new Apple());
        put('s',  new SnakeBody());
    }};

     public static HashMap<Character, FieldObject> getMap() {
         return map;
     }
 }
