package Lesson3;

import java.util.*;

public class ArraysWord {
    public static void main(String[] args) {
        String[] words = new String[]{"industry", "profession", "invasion", "decay", "printer", "printer",
                "recognize", "conventional", "conventional", "cucumber", "printer", "industry", "invasion"};
        List<String> wordsList = new ArrayList<>();
        Collections.addAll(wordsList, words);
        System.out.println("Полный список слов : " + wordsList);
        Map<String, Integer> mapWords = new HashMap<>();
        for (String listWords : wordsList) {
            if  (mapWords.containsKey(listWords)) {
                mapWords.put(listWords, mapWords.get(listWords) + 1);
            } else {
                mapWords.put(listWords, 1);
            }
        }
        System.out.println("Слова без дублей " + mapWords);


    }
}
