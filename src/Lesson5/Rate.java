package Lesson5;

public class Rate extends Thread {


    public Rate(float[] a) {

        @Override
        public void run() {
            for (int i = 0; i < a.length; i++) {
                a[i] = (float)(a[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));;
            }
        }
    }
}
