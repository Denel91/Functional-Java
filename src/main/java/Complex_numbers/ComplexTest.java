package Complex_numbers;

/**
 * Test class for class Complex
 */
public class ComplexTest {
    public static void main(String[] args) {
        Complex a = new Complex(5.0, 6.0);
        Complex b = new Complex(-3.0, 4.0);

        System.out.println("Re(a): " + a.getRe() + ", " + "Im(a): " + a.getIm());
        System.out.println("Re(b): " + b.getRe() + ", " + "Im(b): " + b.getIm());
        System.out.println("a + b: " + a.add(b));
        System.out.println("a - b: " + a.sub(b));
        System.out.println("a * b: " + a.mult(b));
        System.out.println("b * a: " + b.mult(a));
        System.out.println("a * 2: " + a.scale(2));
        System.out.println("b * 2: " + b.scale(2));
        System.out.println("a / b: " + a.div(b));
        System.out.println("(a / b) * b: " + a.div(b).mult(b));
        System.out.println("conj(a): " + a.conj());
        System.out.println("conj(b): " + b.conj());
        System.out.println("|a|: " + a.mod());
        System.out.println("|b|: " + b.mod());
    }
}
