package event;

import Charactor.*;

public class Event {

    public static boolean checkHit(Dev dev, Wave wave) {
        return wave.x <= 200;
    }

}
