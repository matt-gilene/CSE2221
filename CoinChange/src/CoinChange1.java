import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class CoinChange1 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private CoinChange1() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        /*
         * Put your main program code here
         */
        out.print("How much to make change for? (cents) ");
        int amount = in.nextInteger();
        int dollars = amount / 100;
        amount %= 100;
        int halfDollars = amount / 50;
        amount %= 50;
        int quarters = amount / 25;
        amount %= 25;
        int dimes = amount / 10;
        amount %= 10;
        int nickels = amount / 5;
        amount %= 5;
        int pennies = amount;
        out.println("Dollars: " + dollars);
        out.println("Half Dollars: " + halfDollars);
        out.println("Quarters: " + quarters);
        out.println("Dimes: " + dimes);
        out.println("Nickels: " + nickels);
        out.println("Pennies: " + pennies);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
