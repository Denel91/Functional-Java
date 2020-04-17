package Progression;

/**
 * Programma di collaudo per la gerarchia di progressioni
 */
public class TestProgression {
    public static void main(String[] args) {
        Progression prog, prf;

        System.out.print("Fibonacci progression with default start values: ");
        prog = new FibonacciProgression();
        prog.printProgression(10);

        System.out.print("Fibonacci progression with start values 4 and 6: ");
        prf = new FibonacciProgression(4, 6);
        prf.printProgression(10);
    }
}
