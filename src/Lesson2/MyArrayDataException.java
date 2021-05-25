package Lesson2;

public class MyArrayDataException extends Exception {
    public MyArrayDataException() {
        System.out.println("Невозможно преобразовать все элементы массива к типу Integer!" + "\n" + "Проверьте элементы! Все ли относятся к числу?");
    }
}
