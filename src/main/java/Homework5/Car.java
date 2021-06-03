package Homework5;

public class Car implements Runnable {
    private static int CARS_COUNT;
    static int count = 0;

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;


    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;

    }

    @Override
    public void run() {
        try {

            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");

            Racing.announceStart.countDown();
            Racing.announceStart.await();
            Thread.sleep(200);

        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        Racing.announceFinished.countDown();
        isWinner();
    }

    private synchronized void isWinner () {
        count++;
        if (count == 1) System.out.println(this.name + " RACE WINNER");
    }

}


