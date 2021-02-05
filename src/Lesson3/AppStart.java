package Lesson3;

public class AppStart {
    public static void main(String[] args) {
        PhoneContact pc = new PhoneContact();
        pc.add(89998881, "Петров");
        pc.add(12134131, "Иванов");
        pc.add(12314312, "Петров");
        pc.add(997563876, "Басков");
        pc.add(1322323, "Навальный");
        pc.add(272636323, "Петров");


        pc.get("Петров");
        pc.get("Иванов");
    }
}
