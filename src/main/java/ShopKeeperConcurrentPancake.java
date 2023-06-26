import java.time.LocalTime;
import java.util.Random;
//concurrent
public class ShopKeeperConcurrentPancake {
    public static int makePancakes() {
        Random random = new Random();
        return random.nextInt(13);
    }

    public static int eatPancakes() {
        Random random = new Random();
        return random.nextInt(6);
    }

    public static void simulate() {
        LocalTime startingTime = LocalTime.now();
        System.out.println("Starting time: " + startingTime);

        int pancakesMade = makePancakes();
        System.out.println("Pancakes made by the shopkeeper: " + pancakesMade);

        int[] pancakesEaten = new int[3];
        Thread[] userThreads = new Thread[3];

        for (int user = 0; user < 3; user++) {
            final int currentUser = user;
            userThreads[user] = new Thread(() -> {
                pancakesEaten[currentUser] = eatPancakes();
            });
            userThreads[user].start();
        }

        for (Thread userThread : userThreads) {
            try {
                userThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int totalPancakesEaten = 0;
        for (int pancakes : pancakesEaten) {
            totalPancakesEaten += pancakes;
        }

        LocalTime endingTime = LocalTime.now();
        System.out.println("Ending time: " + endingTime);

        if (totalPancakesEaten <= pancakesMade) {
            System.out.println("The shopkeeper was able to meet the needs of the 3 users.");

            if (pancakesMade > totalPancakesEaten) {
                int pancakesWasted = pancakesMade - totalPancakesEaten;
                System.out.println("Pancakes wasted: " + pancakesWasted);
            }
        } else {
            int pancakesShortage = totalPancakesEaten - pancakesMade;
            System.out.println("The shopkeeper was not able to meet the needs of all the customers.");
            System.out.println("Pancake orders not met: " + pancakesShortage);
        }
    }

    public static void main(String[] args) {
        simulate();
    }


}
