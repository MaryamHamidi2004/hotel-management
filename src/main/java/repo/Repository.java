package repo;

import model.User;
import view.login.Login;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Repository {

    public static User currentPerson;
    private static Map<String , Frame> frameMap = new HashMap();

    public static Map<String,Frame> getFrames(){
        Frame[] allFrame = Frame.getFrames();

        for (Frame f : allFrame)
            frameMap.put(f.getName() , f);

        return frameMap;
    }

    public static void logout(){
        currentPerson = null;
        new Login();
    }
}
