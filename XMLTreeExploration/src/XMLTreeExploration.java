import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class XMLTreeExploration {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeExploration() {
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
        XMLTree xml = new XMLTree1(
                "http://xml.weather.yahoo.com/forecastrss/43210.xml");
        XMLTree channel = xml.child(0);
        XMLTree title = channel.child(0);
        XMLTree titleText = title.child(0);
        XMLTree astronomy = channel.child(10);
        XMLTree item = channel.child(12);
        XMLTree forecast = item.child(8);
        //out.print(xml);
        out.println("XML Is Tag? " + xml.isTag());
        out.println("XML Label: " + xml.label());
        out.println("Channel Num Childern: " + channel.numberOfChildren());
        out.println("Title Text Label: " + titleText.label());
        out.println("Title Text Label: "
                + xml.child(0).child(0).child(0).label());
        out.println("Astronomy has sunset: " + astronomy.hasAttribute("sunset"));
        out.println("Astronomy has midday: " + astronomy.hasAttribute("midday"));
        out.println("Sunrise: " + astronomy.attributeValue("sunrise"));
        out.println("Sunset: " + astronomy.attributeValue("sunset"));
        out.println("Root of Astronomy: " + astronomy.label());
        printMiddleNode(channel, out);
        printRootAttributes(forecast, out);
        xml.display();
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

    /**
     * Output information about the middle child of the given {@code XMLTree}.
     *
     * @param xt
     *            the {@code XMLTree} whose middle child is to be printed
     * @param out
     *            the output stream
     * @updates out.content
     * @requires <pre>
     * [the label of the root of xt is a tag]  and
     * [xt has at least one child]  and  out.is_open
     * </pre>
     * @ensures <pre>
     * out.content = #out.content * [the label of the middle child
     *  of xt, whether the root of the middle child is a tag or text,
     *  and if it is a tag, the number of children of the middle child]
     * </pre>
     */
    private static void printMiddleNode(XMLTree xt, SimpleWriter out) {
        int index = xt.numberOfChildren() / 2 - 1;
        XMLTree node = xt.child(index);
        out.println("Label: " + node.label());
        out.println("Type: " + (node.isTag() ? "Tag" : "Text"));
        if (node.isTag()) {
            out.println("Number of childern: " + node.numberOfChildren());
        }
    }

    /**
     * Output all attributes names and values for the root of the given
     * {@code XMLTree}.
     *
     * @param xt
     *            the {@code XMLTree} whose root's attributes are to be printed
     * @param out
     *            the output stream
     * @updates out.content
     * @requires [the label of the root of xt is a tag] and out.is_open
     * @ensures <pre>
     * out.content =
     *   #out.content *  [the name and value of each attribute of the root of xt]
     * </pre>
     */
    private static void printRootAttributes(XMLTree xt, SimpleWriter out) {
        for (String attrib : xt.attributeNames()) {
            out.println(attrib + ": " + xt.attributeValue(attrib));
        }
    }
}
