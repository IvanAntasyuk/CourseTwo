package Lesson1;


import java.util.Random;

public class Robot implements  Action{
    Random random = new Random();
    private int jump = random.nextInt(10);
    private int run = random.nextInt(100);

    public int getJump() {
        return jump;
    }

    public int getRun() {
        return run;
    }

    @Override
    public void run() {
        System.out.println("Я умею бегать на растояния " + getRun());
    }

    @Override
    public void jump() {
        System.out.println("Я умею прыгать на высоту " + getJump());
    }
}
