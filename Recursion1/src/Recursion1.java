import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber1L;

public class Recursion1 {
    public static void main(String[] args) {
        NaturalNumber num = new NaturalNumber1L(1234321);
        System.out.println(numberOfDigits(num));
        System.out.println(sumOfDigits1(num));
        System.out.println(sumOfDigits2(num));
        System.out.println(isPalindrome(num.toString()));
    }

    /**
     * Returns the number of digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to count
     * @return the number of digits of {@code n}
     * @ensures numberOfDigits = [number of digits of n]
     */
    private static int numberOfDigits(NaturalNumber n) {
        NaturalNumber num = n.newInstance();
        num.copyFrom(n);
        if (num.compareTo(new NaturalNumber1L(0)) == 0) {
            return 0;
        } else {
            num.divideBy10();
            return 1 + numberOfDigits(num);
        }
    }

    /**
     * Returns the sum of the digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to add
     * @return the sum of the digits of {@code n}
     * @ensures sumOfDigits = [sum of the digits of n]
     */
    private static int sumOfDigits1(NaturalNumber n) {
        NaturalNumber num = n.newInstance();
        num.copyFrom(n);
        if (num.isZero()) {
            return 0;
        } else {
            int sum = num.divideBy10();
            sum += sumOfDigits1(num);
            return sum;
        }
    }

    /**
     * Returns the sum of the digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to add
     * @return the sum of the digits of {@code n}
     * @ensures sumOfDigits = [sum of the digits of n]
     */
    private static NaturalNumber sumOfDigits2(NaturalNumber n) {
        NaturalNumber num = n.newInstance();
        num.copyFrom(n);
        if (num.isZero()) {
            return new NaturalNumber1L();
        } else {
            NaturalNumber remainder = new NaturalNumber1L(num.divideBy10());
            NaturalNumber sum = new NaturalNumber1L(remainder);
            sum.add(sumOfDigits2(num));
            return sum;
        }
    }

    /**
     * Divides {@code n} by 2.
     *
     * @param n
     *            {@code NaturalNumber} to be divided
     * @updates n
     * @ensures 2 * n <= #n < 2 * (n + 1)
     */
    private static void divideBy2(NaturalNumber n) {
        //absolutely no clue. Seems impossible being a void method.
    }

    /**
     * Checks whether a {@code String} is a palindrome.
     *
     * @param s
     *            {@code String} to be checked
     * @return true if {@code s} is a palindrome, false otherwise
     * @ensures s = rev(s)
     */
    private static boolean isPalindrome(String s) {
        if (s.length() < 2) {
            return true;
        }
        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }
        return isPalindrome(s.substring(1, s.length() - 1));
    }
}
