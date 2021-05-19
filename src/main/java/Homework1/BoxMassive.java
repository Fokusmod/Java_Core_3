package Homework1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class BoxMassive<T> {

    private T[] value;




    public void setValue(T[] value) {
        this.value = value;
    }

    public T[] getValue() {
        return value;
    }

    @SafeVarargs
    public BoxMassive(T... value) {
        this.value = value;
    }

    public void reverseElementMassive(int from, int too) {
        if (value.length - 1 >= from && value.length - 1 >= too) {
            System.out.println(Arrays.toString(value));
            BoxMassive<T> box = new BoxMassive<>(value[from]);
            value[from] = value[too];
            value[too] = box.getValue()[0];
            System.out.println(Arrays.toString(value));
            System.out.println();

        } else System.out.println("Длинна массива меньше чем переданные аргументы");
    }

    public List<T> convertToCollection() {
        return new ArrayList<>(Arrays.asList(value));

    }

}
