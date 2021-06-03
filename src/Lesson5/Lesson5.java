package Lesson5;

import java.util.Arrays;

public class Lesson5 {
    public static void main(String[] args) {
        Rate.arrayAssignmentRate();
        Rate.arrayCopyAssignmentRate();

    }
    public static class Rate extends Thread {
        static final int size = 10000000;
        static final int h = size / 2;


        public static void arrayAssignmentRate() {
            float[] arr = new float[size];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = 1;
            }
            long a = System.currentTimeMillis();
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("Скорость заполнения массива arr " + (System.currentTimeMillis() - a) + " миллисекунд.");
        }
        public static void arrayCopyAssignmentRate() {
            float[] arr = new float[size];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = 1;
            }
            long b = System.currentTimeMillis();
            float[] a1 = new float[h];
            System.arraycopy(arr, 0, a1, 0, h);
            float[] a2 = new float[h];
            System.arraycopy(arr, h, a2, 0, h);

            Rate thread = new Rate();
            thread.start();
            for (int i = 0; i < a1.length; i++) {
                a1[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));;
            }
            Rate thread1 = new Rate();
            thread1.start();
            for (int i = 0; i < a2.length; i++) {
                a2[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));;

            }
            float[] arr1 = new float[size];
            System.arraycopy(a1, 0, arr1, 0, h);
            System.arraycopy(a2, 0, arr1, h, h);
            System.out.println("Скорость деления, заполнения и склейки массива arr " + (System.currentTimeMillis() - b) + " миллисекунд.");
        }
    }
}
