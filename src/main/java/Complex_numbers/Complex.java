package Complex_numbers;

/**
 * Data type for Complex numbers.
 *
 * The data type is "immutable" so once you create and initialize a Complex object, you cannot change it.
 *
 * * Class overview:
 * Complex(double real, double imag) : Constructor with two parameters -> inizializza il numero complesso al valore re + im * i
 * Complex(double real) : Constructor with one parameter -> inizializza il numero complesso al valore re + i0
 * Complex() : Default Constructor -> inizializza il numero complesso al valore 0 + i0
 * getRe() : double
 * getIm() : double
 * add(Complex z) : Complex
 * sub(Complex z) : Complex
 * mult(Complex z) : Complex
 * scale(double alpha) : Complex
 * div(Complex z) : Complex
 * inv() : Complex
 * conj() : Complex
 * mod() : double
 * equals(Complex z) : boolean
 * toString() : String
 *
 * @version 10/05/2020
 */
public class Complex {
    // Private instance variables
    private final double re;        // the real part
    private final double im;        // the imaginary part

    /**
     * Initializes a complex number from the specified real and imaginary parts.
     *
     * @param real the real part
     * @param imag the imaginary part
     */
    public Complex(double real, double imag) {
        this.re = real;
        this.im = imag;
    }

    /**
     * Initializes a complex number from the specified real part
     *
     * @param real the real part
     */
    public Complex(double real) {
        this(real, 0);
    }

    /**
     * Initializes the complex number 0 + i0 (zero complesso)
     */
    public Complex() {
        this(0);
    }

    /**
     * Returns the real part of this complex number.
     *
     * @return the real part of this complex number
     */
    public double getRe() {
        return re;
    }

    /**
     * Returns the imaginary part of this complex number.
     *
     * @return the imaginary part of this complex number
     */
    public double getIm() {
        return im;
    }

    /**
     * Returns the sum of this complex number and the specified complex number.
     *
     * @param z the other complex number
     * @return the complex number whose value is this + z
     */
    public Complex add(Complex z) {
        return new Complex(re + z.re, im + z.im);
    }

    /**
     * Returns the result of subtracting the specified complex number from
     * this complex number.
     *
     * @param z the other complex number
     * @return the complex number whose value is this - z
     */
    public Complex sub(Complex z) {
        return new Complex(re - z.re, im - z.im);
    }

    /**
     * Returns the product of this complex number and the specified complex number.
     *
     * @param z the other complex number
     * @return the complex number whose value is this * z
     */
    public Complex mult(Complex z) {
        return new Complex(re * z.re - im * z.im, re * z.im + im * z.re);
    }

    /**
     * Returns the product of this complex number and the specified scalar.
     *
     * @param alpha the scalar number
     * @return the complex number whose value is alpha * this
     */
    public Complex scale(double alpha) {
        return new Complex(alpha * re, alpha * im);
    }

    /**
     * Returns the result of dividing the specified complex number into
     * this complex number.
     *
     * @param z the other complex number
     * @return the complex number whose value is this / z
     */
    public Complex div(Complex z) {
        return this.mult(z.inv());
    }

    /**
     * Returns the reciprocal of this complex number.
     *
     * @return the complex number whose value is 1 / this
     */
    public Complex inv() {
        return new Complex(re / powMod(), -im / powMod());
    }

    /**
     * Returns the complex conjugate of this complex number.
     *
     * @return the complex conjugate of this complex number
     */
    public Complex conj() {
        return new Complex(re, -im);
    }

    /**
     * Returns the absolute value of this complex number.
     *
     * @return the absolute value of this complex number
     */
    public double mod() {
        return Math.hypot(re, im);
    }

    private double powMod() {
        return re * re + im * im;
    }

    /**
     * Verify if two complex numbers are equals
     *
     * @param obj the other complex number
     * @return true if this and z are equals, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Complex) {
            Complex z = (Complex) obj;
            return (this.re == z.re) && (this.im == z.im);
        }

        return false;
    }

    /**
     * Returns a string representing the complex number in mathematical format: a + ib
     *
     * @return a string representing the complex number
     */
    @Override
    public String toString() {
        if (im == 0) {
            return re + "";
        }
        if (re == 0) {
            return im + "i";
        }
        if (im < 0) {
            return re + " - " + (-im) + "i";
        }
        return re + " + " + im + "i";
    }
}
