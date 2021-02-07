package Lesson4;

import Lesson4.Interface.SearchSymbol;

import java.util.ArrayList;
import java.util.List;

public class SearchSymbolArray {
    public static void main(String[] args) {
        List<String> word = new ArrayList<>();
        word.add("hi");
        word.add("Hell");
        word.add("hat");
        word.add("hell");
        SearchSymbol s;
        s = (list) -> {
            for (String str :list) {
                if (str.charAt(0) == 'h' && str.length() == 3) {
                    System.out.println(str);
                }
            }
            return list;
        };
        s.search(word);
    }


}
