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
public final class HailstoneRecursive {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private HailstoneRecursive() {
    }

    /**
     * Generates and outputs the Hailstone series starting with the given
     * integer.
     *
     * @param n
     *            the starting integer
     * @param out
     *            the output stream
     */
    private static void generateSeries(int n, SimpleWriter out) {
        out.print(n + " ");
        if (n <= 0) {
            return;
        } else {
            if (n == 1) {
                return;
            } else {
                if (n % 2 == 0) {
                    generateSeries(n / 2, out);
                } else {
                    generateSeries(3 * n + 1, out);
                }
            }
        }
    }

    /**
     * Asks the user for a positive integer ands then outputs the Hailstone
     * series for that number.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        /*
         * Put your main program code here; it may call myMethod as shown
         */
        out.println("Enter a positive integer:");
        int num = in.nextInteger();
        generateSeries(num, out);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
