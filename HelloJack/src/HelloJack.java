import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Matt Gilene, Quinn McHugh
 *
 */
public final class HelloJack {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private HelloJack() {
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
        out.println("Enter your name:");
        String name = in.nextLine();
        out.println("Hello " + name);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
