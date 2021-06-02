package Serialization;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        byte [] byteCat = null;

        Cat cat = null;
        Cat cat2 = null;

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream objOut = new ObjectOutputStream(out)) {
            cat = new Cat("Барсик");
            objOut.writeObject(cat);
            byteCat = out.toByteArray();
            System.out.println("Кот до сериализации " + cat);
            System.out.println("Кот в байтах " + Arrays.toString(byteCat));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            assert byteCat != null;
            try (ByteArrayInputStream in = new ByteArrayInputStream(byteCat);
                     ObjectInputStream readCat = new ObjectInputStream(in)) {
                cat2 = (Cat) readCat.readObject();
                System.out.println("Новый кот " + cat2);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(cat.equals(cat2));
    }
}
