package Introduction;

public class FirstProgram {
    public static void main(String[] args) {
        // write your code here
        System.out.println(supToCil(2.6,3.4));

        System.out.println(pluraleSm("Albero"));
    }

    /**
     * @param r: raggio
     * @param h: altezza
     * @return
     */
    public static double supToCil(double r, double h) {

        return (2 * Math.PI * (r + h));
    }

    /**
     *
     * @param s: a string value
     * @return the plural name of a string
     */
    public static String pluraleSm(String s) {

       return (s.substring(0, s.length()-1) + "i");
    }

    public static int multiplyByTwo(int i) {
        int var = 2;
        return i * var;
    }
}


