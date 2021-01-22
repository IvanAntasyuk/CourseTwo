package Lesson1;

import java.util.Random;

public class Wall {
    Random random = new Random();

    public int getHigh() {
        return high;
    }

    private int high = random.nextInt(10);
}

