import java.util.Scanner;
/**
 * Program Description
 * Displays the distance an object falls for each second up to a certain number entered by the user.
 * 1) Prompts the user for how many seconds to compute
 * 2) Displays a table header for Time(secs) and Distance(m)
 * 3) Uses a for loop to call getDistance() for each second
 * 4) Displays each second and its falling distance to one decimal place
 * 
 * @author Tobey Agapito
 * @version v1.0
 * @since 10/04/2026
 */

public class FallingDistance {
    public static final double ACCELERATION = 9.8;  
    public static void main (String[] args) {
        Scanner keyboard = new Scanner(System.in);
        double distance;
        int numOfSecs;

        System.out.print("Please enter how many seconds to compute: ");
        numOfSecs = keyboard.nextInt();

        System.out.println("Time(secs)\tDistance(m)");
        System.out.println("==========\t===========");

        for (int second = 1; second <= numOfSecs; second++) {
            distance = getDistance(second);
            System.out.printf("%10d\t%11.1f\n", second, distance);
        }
    }

    /**
     * Calculates the distance an object falls in a given number of seconds using the formula d = 0.5 * g * t^2.
     * @param seconds the number of seconds the object has been falling
     * @return the distance in meters the object falls in that time
     */
    public static double getDistance(int seconds) {
        return 0.5 * ACCELERATION * Math.pow(seconds, 2);
    }
}