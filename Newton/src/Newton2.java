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
public final class Newton2 {

    /**
     * Constant for the maximum allowed error.
     */
    private static final double MAX_ERROR = 0.01;

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton2() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            number to compute the square root of, x > -1
     * @return estimate of square root
     */
    private static double sqrt(double x) {
        if (x == 0) {
            return 0;
        }
        double guess = x / 2;
        double error = 100 * Math.abs((Math.pow(guess, 2) - x)) / x;
        while (error > MAX_ERROR) {
            guess = (guess + x / guess) / 2;
            error = 100 * Math.abs((Math.pow(guess, 2) - x)) / x;
        }
        return guess;
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
        String answer = "n";
        do {
            //ask the user for a positive number to calculate the root of.
            out.println("Enter the number you wish to calculate the root of...");
            double number = in.nextDouble();
            out.println("Root: " + sqrt(number));
            out.println("Actual: " + Math.sqrt(number));
            //ask if user would like to run the program again.
            out.println("Would you like to calculate another root? (y=yes,n=no)");
            answer = in.nextLine();
        } while (answer.equals("y"));

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
