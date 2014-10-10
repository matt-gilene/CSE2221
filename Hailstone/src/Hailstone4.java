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
public final class Hailstone4 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Hailstone4() {
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
        if (n <= 0) {
            return;
        } else {
            int next = n;
            int len = 1;
            int max = next;
            while (next != 1) {
                out.print(next + " ");
                if (next % 2 == 0) {
                    next /= 2;
                } else {
                    next = next * 3 + 1;
                }
                len++;
                max = next > max ? next : max;
            }
            out.println(1);
            out.println("Lenght: " + len);
            out.println("Max: " + max);
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
        String ans = "n";
        do {
            out.println("Enter a positive integer:");
            int num = in.nextInteger();
            generateSeries(num, out);
            out.println("Generate another series? (y=yes n=no)");
            ans = in.nextLine();
        } while (ans.equals("y"));
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
