package Lesson1;


import java.util.Random;

public class Cat  implements  Action{

    Random random = new Random();
    private int jump = random.nextInt(10);
    private int run = random.nextInt(100);


    public int getRun() {
        return run;
    }


    public int getJump() {
        return jump;
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
