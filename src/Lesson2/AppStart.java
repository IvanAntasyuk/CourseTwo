package Lesson2;

public class AppStart {public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
    String[][] strings = new String[][]{{"1", "2", "3", "4",}, {"5", "6", "7", "8",}, // Выбросит два исключения
            {"9", "10", "11", "12"}, {"14", "15", "Не число"}};//Размер и символ
    // String[][] strings = new String[][]{{"1", "2", "3", "4",}, {"5", "6", "7", "8",}, // Выбросит одно исключения
    //         {"9", "10", "11", "12"}, {"14", "15", "1"}}; // размер массива
    //String[][] strings = new String[][]{{"1", "2", "3", "4",}, {"5", "6", "7", "8",}, // Выбросит одно исключения
    //         {"9", "10", "11", "12"}, {"14", "15", "o", "2"}}; // символ в масиве
    //String[][] strings = new String[][]{{"1", "2", "3", "4",}, {"5", "6", "7", "8",}, // Без исключений
    //         {"9", "10", "11", "12"}, {"14", "15", "16", "17"}}; //

    try {
        numbersOne(strings);
    }catch (RuntimeException e){
        System.out.println(e);
    }


}

    public static void numbersOne(String[][] str) throws MyArraySizeException, MyArrayDataException {
        final int SIZE_ARRAYS = 4;
        int sum = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i].length != SIZE_ARRAYS || str.length != SIZE_ARRAYS) try {
                throw new MyArraySizeException("Не верный размер массива");
            } catch (MyArraySizeException e) {
                System.out.println(e); }
        }
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str[i].length; j++) {
                try {
                    sum += Integer.parseInt(str[i][j]);
                } catch (RuntimeException e1 ) {
                    throw new MyArrayDataException(e1 + " находится в  ячейке " + i + " : " + j + " Сумма чисел : " + sum);


                }
            }
        }
    }
}
