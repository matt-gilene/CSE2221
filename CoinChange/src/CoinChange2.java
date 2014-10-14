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
public final class CoinChange2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private CoinChange2() {
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
        out.print("How much to make change for? ");
        int amount = (in.nextInteger());
        int denominations[] = { 100, 50, 25, 10, 5, 1 };
        String[] denominationNames = { "Dollars", "Half Dollars", "Quarters",
                "Dimes", "Nickels", "Pennies" };

        for (int i = 0; i < denominations.length; i++) {
            out.println(denominationNames[i] + ": " + amount / denominations[i]);
            amount %= denominations[i];
        }

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }
}
