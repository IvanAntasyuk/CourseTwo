package Lesson3;

import java.util.Map;
import java.util.TreeMap;

public class PhoneContact {
    private static Map<Integer, String> contact = new TreeMap<>();


    static public void add(Integer i, String s) {
        contact.put(i, s);
    }

    static public void get(String s) {
        for (Map.Entry<Integer, String> entry : contact.entrySet()) {
            if (entry.getValue().equals(s)) {
                System.out.println("Найден контакт : " + s + " номер :" + entry.getKey());
            }
        }
    }

}


