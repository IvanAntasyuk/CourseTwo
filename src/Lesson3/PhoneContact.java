package Lesson3;

import java.util.Map;
import java.util.TreeMap;

public class PhoneContact {
    private static Map<Integer, String> contact = new TreeMap<>();


    static public void add(Integer number, String name) {
        contact.put(number, name);
    }

    static public void get(String name) {
        for (Map.Entry<Integer, String> entry : contact.entrySet()) {
            if (entry.getValue().equals(name)) {
                System.out.println("Найден контакт : " + name + " номер :" + entry.getKey());
            }
        }
    }

}


