import java.util.Scanner;
/**
 * Program Description
 * Tests if whole numbers entered by user are prime and lets the
 * user keep testing numbers until they quit.
 * 1) Prompts the user for a whole number greater than 2
 * 2) Calls testForPrime() to determine whether the number is prime
 * 3) Displays the number and whether it is prime or not prime
 * 4) Asks the user whether to test another number (do while loop)
 * 
 * @author Tobey Agapito
 * @version v1.0
 * @since 10/04/2026
 */
public class Prime {
    public static void main (String[] args) {
        boolean isPrime;
        int number;
        String playAgain;
        do{
            System.out.print("Enter a whole number>2 (ie 19) to test if prime: ");
            Scanner keyboard = new Scanner(System.in);
            number = keyboard.nextInt();
            isPrime = testForPrime(number);
            if (isPrime)
                System.out.println(number + " is prime");
            else
                System.out.println(number + " is not prime");

            System.out.print("Enter yes to test another number, no to quit. ");
            playAgain = keyboard.next();
        } while (playAgain.equalsIgnoreCase("yes"));
    }

    /**
     * Determines whether a whole number is prime by checking for divisors
     * from 2 up to the square root of the number.
     * @param inNumber the whole number to test
     * @return true if inNumber is prime, false if it is not prime
     */
    public static boolean testForPrime(int inNumber) {
        int inNumberSqRt;
        inNumberSqRt = (int)Math.sqrt(inNumber);
        boolean isPrimeMeth = true;

        for(int i=2;isPrimeMeth&&i<=inNumberSqRt;i++){
            if (inNumber % i == 0)
                isPrimeMeth = false;
        }
        return isPrimeMeth;
    }
}