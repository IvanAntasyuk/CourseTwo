package Lesson4;

import Lesson4.Interface.SearchNumMax;

public class NumberMax {
    public static void main(String[] args) {
        Integer [] num1 ={12,10,2,9,30,99,100,99999};

        SearchNumMax numMax;
        numMax = (list) ->{
            int maximum= 0 ;
            for (int i = 0; i < list.length; i++) {
                if (list[i] >maximum ){
                    maximum=list[i];
                }
            }
            return maximum;
        };
        System.out.println(numMax.number(num1));
    }
}
