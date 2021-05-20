package part2;

public class Main {
    public static void main(String[] args) {
        Box<Apple> box1 = new Box<>();
        Box<Orange> box2 = new Box<>();



        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        Box<Orange> orangeBox1 = new Box<>();

        Apple apple = new Apple();
        Orange orange = new Orange();

        appleBox.addFruit(apple);
        appleBox.addFruit(apple);
        appleBox.addFruit(apple);

        orangeBox.addFruit(orange);
        orangeBox.addFruit(orange);

        orangeBox1.addFruit(orange);
        orangeBox1.addFruit(orange);
        orangeBox1.addFruit(orange);


        System.out.println("appleBox = " + appleBox.fruitWeight());
        System.out.println("orangeBox = " + orangeBox.fruitWeight());
        System.out.println("orangeBox1 = " + orangeBox1.fruitWeight());
        System.out.println();

        System.out.println("Результат сравнения appleBox и appleBox : " + appleBox.compare(appleBox));
        System.out.println("Результат сравнения appleBox и orangeBox : " + appleBox.compare(orangeBox));
        System.out.println("Результат сравнения appleBox и orangeBox1 : " + appleBox.compare(orangeBox1));
        System.out.println();

        System.out.println("Коробка appleBox: " + appleBox.getFruitBox());
        System.out.println("Коробка box1: " + box1.getFruitBox());
        appleBox.transferBox(box1);
        System.out.println("Коробка appleBox: " + appleBox.getFruitBox());
        System.out.println("Коробка box1: " + box1.getFruitBox());



    }


}
