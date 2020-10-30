package game;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Util {

    static int random(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    static List<Integer> random(int min, int max, int FILL_MAX_COLS) {
        Random random = new Random();
        return random.ints(min, max).distinct().limit(FILL_MAX_COLS).boxed().collect(Collectors.toList());
    }

}
