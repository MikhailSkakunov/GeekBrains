package Lesson5;

import java.util.Arrays;

public class Lesson5 {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) throws InterruptedException {

        float[] arr = new float[size];
        Arrays.fill(arr, 1);

        long a = System.currentTimeMillis();
        float[] a1 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
//        System.out.println("Первая половина массива " + Arrays.toString(a1));

        float[] a2 = new float[h];
        System.arraycopy(arr, h, a2, 0, h);
//        System.out.println("Вторая половина массива " + Arrays.toString(a1));

        Thread thread1 = new Rate(a1, 0);
        Thread thread2 = new Rate(a2, h);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        float[] arr1 = new float[size];
        System.arraycopy(a1, 0, arr1, 0, a1.length);
        System.arraycopy(a2, 0, arr1, h, a2.length);
         System.out.println("Скорость вычисления склеиного массива: " + (System.currentTimeMillis() - a));

        long b = System.currentTimeMillis();
        Thread thread3 = new Rate(arr, 0);
        thread3.start();
        thread3.join();
        System.out.println("Скорость вычисления начального массива: " + (System.currentTimeMillis() - b));

 //       System.out.println(Arrays.toString(arr) + "\n" + Arrays.toString(arr1));
        System.out.println("Равны ли в конечном итоге массивы arr и arr1 " + Arrays.equals(arr, arr1));

    }
}

