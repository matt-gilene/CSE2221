import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Estimates a given µ using 4 entered values via the de Jagger formula.
 *
 * @author Matt
 *
 */
public final class ABCDGuesser1 {

    /**
     * Constructor.
     */
    private ABCDGuesser1() {
    }

    /**
     * Program entry point.
     *
     * @param args
     *            launch arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        //ALT CODE FOR µ = ALT+230

        //exponent array
        final double[] exponents = { -5, -4, -3, -2, -1, (double) -1 / 2,
                (double) -1 / 3, (double) -1 / 4, 0, (double) 1 / 4,
                (double) 1 / 3, (double) 1 / 2, 1, 2, 3, 4, 5 };
        double constant, w, x, y, z;

        //user prompting/input
        out.print("Enter your favorite constant to estimate: ");
        constant = in.nextDouble();
        out.print("Enter your first favorite number(Not 1): ");
        w = in.nextDouble();
        out.print("Enter your second favorite number(Not 1): ");
        x = in.nextDouble();
        out.print("Enter your thrird favorite number(Not 1): ");
        y = in.nextDouble();
        out.print("Enter your fourth favorite number(Not 1): ");
        z = in.nextDouble();

        int a = 0, b = 0, c = 0, d = 0;
        int a1 = 0, b1 = 0, c1 = 0, d1 = 0;
        double estimate = 0;
        double lowError = error(constant, estimate);

        //main loop
        while (a < exponents.length) {
            while (b < exponents.length) {
                while (c < exponents.length) {
                    while (d < exponents.length) {
                        //de Jagger formula
                        double newEstimate = Math.pow(w, exponents[a])
                                * Math.pow(x, exponents[b])
                                * Math.pow(y, exponents[c])
                                * Math.pow(z, exponents[d]);
                        //calculate error
                        double newError = error(constant, newEstimate);
                        //if smaller then replace
                        if (newError < lowError) {
                            estimate = newEstimate;
                            lowError = newError;
                            a1 = a;
                            b1 = b;
                            c1 = c;
                            d1 = d;
                        }
                        d++;
                    }
                    c++;
                    d = 0;
                }
                b++;
                c = 0;
            }
            a++;
            b = 0;
        }

        //output results
        out.println("µ: " + constant);
        out.println("Estimate: " + estimate);
        out.println("ABDC Values: " + exponents[a1] + " " + exponents[b1] + " "
                + exponents[c1] + " " + exponents[d1]);
        out.println("Error = " + error(constant, estimate) + " %");

        in.close();
        out.close();
    }

    /**
     * Calculates the % error between the two numbers.
     *
     * @param a
     *            first value
     * @param b
     *            second value
     * @return error %
     */
    private static double error(double a, double b) {
        return Math.abs(a - b) / a * 100;
    }
}
