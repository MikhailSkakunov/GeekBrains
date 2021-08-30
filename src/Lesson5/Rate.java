package Lesson5;

public class Rate extends Thread {
    float[] arr;
    int index;

    Rate(float[] arr, int index) {
        this.arr = arr;
        this.index = index;
    }
    @Override
            public void run() {
        for (int i = 0; i < arr.length; i++) {
            float value = arr[i];
            arr[i] = arrayComputation(value,i + index);
        }
    }
    private float arrayComputation(float value, int id) {
       return  (float)(value * Math.sin(0.2f + id / 5) * Math.cos(0.2f + id / 5) * Math.cos(0.4f + id / 2));
    }
}
