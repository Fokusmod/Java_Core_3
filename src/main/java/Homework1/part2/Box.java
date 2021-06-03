package part2;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

    private final List<T> fruitBox;


    public Box() {
        this.fruitBox = new ArrayList<>();
    }

    public List<T> getFruitBox() {
        return fruitBox;
    }


    public void addFruit(T fruit) {
        this.fruitBox.add(fruit);

    }


    public float fruitWeight() {
        return this.fruitBox.get(0).getWeight() * fruitBox.size();

    }

    public boolean compare (Box<?> another){
        return Math.abs(fruitWeight() - another.fruitWeight()) < 0.0001;
    }

    public void transferBox (Box<T> another) {
        if (this.fruitBox == another) return;
        another.getFruitBox().addAll(this.fruitBox);
        fruitBox.clear();
    }

    public void method () {

    }


}






