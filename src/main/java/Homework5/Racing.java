package Homework5;

import java.io.IOException;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Racing {
    public static final int CARS_COUNT = 4;
    public static CountDownLatch countDownLatch = new CountDownLatch(1);
    public static CountDownLatch countDownLatch2 = new CountDownLatch(12);



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


        countDownLatch.await();

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");


        countDownLatch2.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");




        }
}


//
//


//    Организуем гонки:
//        Все участники должны стартовать одновременно, несмотря на то, что на подготовку у каждого из них уходит разное время.
//        В туннель не может заехать одновременно больше половины участников (условность).
//        Попробуйте всё это синхронизировать.
//        Только после того как все завершат гонку, нужно выдать объявление об окончании.
//        Можете корректировать классы (в т.ч. конструктор машин) и добавлять объекты классов из пакета util.concurrent.
//        Пример выполнения кода до корректировки: