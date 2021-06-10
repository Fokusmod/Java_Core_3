package Reflection;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {

        Arithmetic arithmetic = new Arithmetic(20,50);

        try {
            RunningTest.startTest(Arithmetic.class,arithmetic);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
