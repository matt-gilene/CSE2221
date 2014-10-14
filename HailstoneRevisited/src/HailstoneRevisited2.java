import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber1L;
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
public final class HailstoneRevisited2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private HailstoneRevisited2() {
    }

    /**
     * Generates and outputs the Hailstone series starting with the given
     * {@code NaturalNumber}.
     *
     * @param n
     *            the starting natural number
     * @param out
     *            the output stream
     * @updates out.content
     * @requires n > 0 and out.is_open
     * @ensures out.content = #out.content * [the Hailstone series starting with
     *          n]
     */
    private static void generateSeries(NaturalNumber n, SimpleWriter out) {
        int count = 0;
        if (n.isZero()) {
            return;
        } else {
            NaturalNumber next = new NaturalNumber1L(n);
            while (next.toInt() != 1) {
                count++;
                out.print(next + " ");
                NaturalNumber nTemp = new NaturalNumber1L(next);
                if (nTemp.divide(new NaturalNumber1L(2)).equals(
                        new NaturalNumber1L(0))) {
                    next.divide(new NaturalNumber1L(2));
                } else {
                    next.multiply(new NaturalNumber1L(3));
                    next.add(new NaturalNumber1L(1));
                }
            }
            out.println(1);
            out.println("Length: " + count + 1);
        }
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
         * Put your main program code here; it may call myMethod as shown
         */
        out.println("Enter a positive integer:");
        int num = in.nextInteger();
        generateSeries(new NaturalNumber1L(num), out);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
