package Lesson2;

public class Lesson2 {

    public static void main(String[] args) {
        String[][] array = new String[][]{{"1","2","3","4"}, {"1","2","n","4"}, {"1","2","3","4"}, {"1","2","3","4"}};
        try {
            workingArray(array);
            } catch (MyArraySizeException e) {
            System.out.println();
            }
            catch (MyArrayDataException e) {
            System.out.println();
        }

    }

    private static void workingArray(String[][] array) throws MyArraySizeException, MyArrayDataException {

        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException();
        }

            int sum = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                try {
                    sum += Integer.parseInt(String.valueOf(array[i][j]));
                }
                catch (NumberFormatException e) {
                    System.out.println("Не преобразовать к типу int! Проверьте данные!");
                    throw new MyArrayDataException();
                }
                    System.out.print(sum + " ");
                }
            }
        System.out.println();
    }
}
