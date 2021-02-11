package Lesson5;

public class Multithreading {
    static final int size = 10000000;
    static final int h = size / 2;
    public float[] formula(float[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = (float) (arr[i] * Math.sin(0.2f + arr[i] / 5) * Math.cos(0.2f + arr[i] / 5) * Math.cos(0.4f + arr[i] / 2));
        return arr;}

    public void methodOne() {
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++)  {arr[i] = 1;}
        long a = System.currentTimeMillis();
        formula(arr);
        System.currentTimeMillis();
        System.out.println(System.currentTimeMillis() - a);
    }

    public  void methodTwo() {
        float[] arr = new float[size];
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        for (int i = 0; i < arr.length; i++) { arr[i] = 1;}
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        new Thread(){
            @Override
            public void run() {
                formula(a1);
                System.arraycopy(a1, 0, arr, 0, h);
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                formula(a2);
                System.arraycopy(a2, 0, arr, h, h);

            }
        }.start();

        System.out.println(System.currentTimeMillis() - a);
    }
}
