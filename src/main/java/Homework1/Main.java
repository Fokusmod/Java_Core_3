package Homework1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer[] integers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] strings = {"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять", "десять"};

        List<Integer> integerList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();

        reverse(3, 7, integers);
        reverse(5, 10, strings);

        convertToCollection(integerList, integers);
        convertToCollection(stringList, strings);

        System.out.println(integerList);
        System.out.println(stringList);
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
    private static <T> void  convertToCollection(List<T> list, T... arr) {
       list.addAll(Arrays.asList(arr));
    }

}
