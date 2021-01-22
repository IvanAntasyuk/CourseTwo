package Lesson1;


import java.util.Random;

public class Track {
    Random random = new Random();
    private int distance = random.nextInt(100);

    public int getDistance() {
        return distance;
    }
}
