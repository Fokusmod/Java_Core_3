package part1;


import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] integers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] strings = {"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять", "десять"};

        reverse(3, 7, integers);
        reverse(5, 10, strings);
        convertToCollection(integers);


    }

    @SafeVarargs
    private static <T> void reverse(int a, int b, T... arr) {
        System.out.println(Arrays.toString(arr));
        T first = arr[a];
        arr[a] = arr[b];
        arr[b] = first;
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }

    @SafeVarargs
    private static <T> ArrayList<T> convertToCollection(T... arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }

}
