package Reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class RunningTest {


    public static void startTest(Class c, Object object) throws InvocationTargetException, IllegalAccessException {
        if (test(c)) {
            for (Method m : c.getDeclaredMethods()) {
                if (m.isAnnotationPresent(BeforeSuite.class)) {
                    System.out.println(m.invoke(object));
                }
            }
            TreeMap<Integer, Method> list = new TreeMap<>(Comparator.reverseOrder());
            for (Method m : c.getDeclaredMethods()) {
                if (m.isAnnotationPresent(Test.class)) {
                    int value = (m.getAnnotation(Test.class).priority());
                    list.put(value, m);
                }
            }
            for (Method value1 : list.values()) {
                System.out.println("RESULT " + value1.getName() + ": " + value1.invoke(object));
            }
            for (Method m : c.getDeclaredMethods()) {
                if (m.isAnnotationPresent(AfterSuite.class)) {
                    System.out.println(m.invoke(object));
                }
            }
        }
    }

    public static boolean test(Class c) {
        if (!c.isAnnotationPresent(ClassForTest.class))
            throw new RuntimeException("Переданый класс не содержит аннотации @AnnotationTest");

        int countBefore = 0;
        int countAfter = 0;
        for (Method m : c.getDeclaredMethods()) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                countBefore++;
            } else if (m.isAnnotationPresent(AfterSuite.class)) {
                countAfter++;
            }
            if (countBefore > 1)
                throw new RuntimeException("Метод @BeforeSuite должен присутствовать в единственном экземпляре");
            if (countAfter > 1)
                throw new RuntimeException("Метод @AfterSuite должен присутствовать в единственном экземпляре");
        }
        return true;
    }
}
