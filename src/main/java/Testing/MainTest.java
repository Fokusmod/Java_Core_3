package Testing;

import java.util.ArrayList;
import java.util.Arrays;

public class MainTest {
    private static final int FOUR = 4;


    public int[] checkFourAndReturnArray(int[] arr) {
        int count = 0;
        int[] newArr = new int[0];
        for (int i : arr) {
            if (i == FOUR) count++;
        }
        if (count == 0) {
            throw new RuntimeException("Массив не содержит значения 4");
        }
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] == FOUR) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = i + 1; j < arr.length; j++) {
                    list.add(arr[j]);
                }
                newArr = new int[list.size()];
                for (int y = 0; y < newArr.length; y++) {
                    newArr[y] = list.get(y);
                }
                return newArr;
            }
        }
        return null;
    }

    public boolean checkOneOrFour(int[] arr) {
        int count = 0;
        for (int j : arr) {
            if (j == 1 || j == 4) {
                count++;
            } else {
                throw new RuntimeException("Массив не содержит числа 1 и 4");
            }
        }
        return count > 0;
    }


}


//Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив. Метод должен
//вернуть новый массив, который получен путем вытаскивания из исходного массива элементов, идущих после последней
//четверки. Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить RuntimeException.
//Написать набор тестов для этого метода (по 3-4 варианта входных данных). Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].

//Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или единицы,
//то метод вернет false; Если в массиве есть числа отличные от 1 и 4, то метод выбрасывает RuntimeException;
//Написать набор тестов для этого метода (по 3-4 варианта входных данных).