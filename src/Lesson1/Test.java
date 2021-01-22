package Lesson1;
public class Test {
    public static void main(String[] args) {
        Human h2 = new Human(); //h2.jump();h2.run();
        Robot r2 = new Robot(); //r2.jump();r2.run();
        Cat c2 = new Cat();     //c2.jump();c2.run();

        Human h1[] = new Human[]{new Human(), new Human(), new Human()};
        Cat c1[] = new Cat[]{new Cat(), new Cat(), new Cat()};
        Robot r1[] = new Robot[]{new Robot(), new Robot(), new Robot()};
        Track t1 = new Track();
        Wall w1 = new Wall();
        robotRunAndJump(r1, t1, w1);
        humanRunAndJump(h1, t1, w1);
        catRunAndJump(c1, t1, w1);


    }

    private static void robotRunAndJump(Robot[] r1, Track t1, Wall w1) {
        for (int i = 0; i < r1.length; i++) {
            if (r1[i].getRun() >= t1.getDistance() && r1[i].getJump() >= w1.getHigh()) {
                System.out.println("Робот пробежал  " + r1[i].getRun() + " из " + t1.getDistance() +
                        " и перепрыгнула через забор высотой " + w1.getHigh());
            } else {
                System.out.println("Робот не смог пробежать и исключен из соревнований");
            }
        }
    }

    private static void humanRunAndJump(Human[] h1, Track t1, Wall w1) {
        for (int i = 0; i < h1.length; i++) {
            if (h1[i].getRun() >= t1.getDistance() && h1[i].getJump() >= w1.getHigh()) {
                System.out.println("Человек  пробежал  " + h1[i].getRun() + " из " + t1.getDistance() +
                        " и перепрыгнула через забор высотой " + w1.getHigh());
            } else {
                System.out.println("Человек не смог пробежать и исключен из соревнований");
            }
        }
    }

    private static void catRunAndJump(Cat[] c1, Track t1, Wall w1) {
        for (int i = 0; i < c1.length; i++) {
            if (c1[i].getRun() >= t1.getDistance() && c1[i].getJump() >= w1.getHigh()) {
                System.out.println("Кошка  пробежал  " + c1[i].getRun() + " из " + t1.getDistance() +
                        " и перепрыгнула через забор высотой " + w1.getHigh());
            } else {
                System.out.println("Кошка не смогла пробежать и исключена из соревнований");
            }
        }
    }
}


