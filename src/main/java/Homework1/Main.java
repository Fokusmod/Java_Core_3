package Homework1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        BoxMassive<Integer> firstBox = new BoxMassive<>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        BoxMassive<String> SecondBox = new BoxMassive<>("один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять", "десять");
        firstBox.reverseElementMassive(3, 5);
        SecondBox.reverseElementMassive(4,6);

        List<String> stringList =  SecondBox.convertToCollection();
        List<Integer> integerList = firstBox.convertToCollection();

        System.out.println(stringList);
        System.out.println(integerList);








    }


}
//1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
//2. Написать метод, который преобразует массив в ArrayList;