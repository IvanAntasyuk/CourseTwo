package Lesson4;

import Lesson4.Interface.StringReverse;

public class LambdaStringReverse {
    public static void main(String[] args) {

        StringReverse rev;
        rev = (str) -> {
            StringBuffer buffer = new StringBuffer(str);
            buffer.reverse();
            String st = buffer.toString();
            return st;
        };
        System.out.println(rev.string("Надеюсь я все правильно сделал"));


    }
}
