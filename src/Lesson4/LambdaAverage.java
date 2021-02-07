package Lesson4;

import Lesson4.Interface.NumberAverage;

import java.util.ArrayList;

public class LambdaAverage {
    public static void main(String[] args) {
        ArrayList<Integer> in = new ArrayList<>();
        in.add(10);
        in.add(20);
        in.add(30);
        in.add(40);


        NumberAverage num;
        num = (list) -> {
            int total = 0;
            double avg = 0.0;
            for (int i = 0; i < list.size(); i++) {
                total = list.get(i) + total;
                avg = total / list.size();
            }
            return avg;
        };


        System.out.println(num.average(in));


    }
}
