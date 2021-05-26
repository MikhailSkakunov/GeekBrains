package Lesson2;

public class MyArraySizeException extends Exception {
    public MyArraySizeException() {
            System.out.println("На вход поступил массив не соответствующего размера!" + "\n" + "Создайте двумерный массив размерностью 4*4!");
    }
}
