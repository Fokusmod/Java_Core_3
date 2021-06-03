package Homework5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;

public class Racing {
    public static final int CARS_COUNT = 4;
    public static CountDownLatch announceStart = new CountDownLatch(CARS_COUNT);
    public static CountDownLatch announceFinished = new CountDownLatch(CARS_COUNT);



    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {


        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        Race race = new Race(new Road(60), new Tunnel(), new Road(40));// трасса
        Car[] cars = new Car[CARS_COUNT]; // массив машин


        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10)); // создание каждой машины
        }

        for (Car car : cars) { // запуск гонки
            new Thread(car).start();



        }
        announceStart.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        announceFinished.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");

        }
}
