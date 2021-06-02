package ThreadTest;

public class Test {

    private final static Object monitor = new Object();
    private static char letter = 'A';

    public static void main(String[] args) throws InterruptedException {

        Thread threadOne = new Thread(() -> {
            try {
                printA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadTwo = new Thread(() -> {
            try {
                printB();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadThree = new Thread(() -> {
            try {
                printC();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadOne.start();
        threadTwo.start();
        threadThree.start();

        threadOne.join();
        threadTwo.join();
        threadThree.join();

        System.out.println("Основной поток закончил работу");


    }

    public static void printA() throws InterruptedException {
        synchronized (monitor) {
            for (int i = 0; i <= 5; i++) {
                while (letter != 'A') {
                    monitor.wait();
                }
                    Thread.sleep(1000);
                    System.out.print("A = " + i + " - " + Thread.currentThread().getName() + "  ");
                    letter = 'B';
                    monitor.notifyAll();
                }
            }
        }


    public static void printB() throws InterruptedException {
        synchronized (monitor) {
            for (int i = 0; i <= 5; i++) {
                while (letter != 'B') {
                    monitor.wait();
                }
                Thread.sleep(2000);
                System.out.print("B = " + i + " - " + Thread.currentThread().getName() + "  ");
                letter = 'C';
                monitor.notifyAll();
            }
        }
    }

    public static void printC() throws InterruptedException {
        synchronized (monitor) {
            for (int i = 0; i <= 5; i++) {
                while (letter != 'C') {
                    monitor.wait();
                }
                Thread.sleep(1500);
                System.out.println("C = " + i + " - " + Thread.currentThread().getName());
                letter = 'A';
                monitor.notifyAll();
            }
        }
    }
}


//1. Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз (порядок – ABСABСABС). Используйте wait/notify/notifyAll.