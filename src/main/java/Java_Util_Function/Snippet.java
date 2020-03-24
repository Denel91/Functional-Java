package Java_Util_Function;

import java.util.function.*;

/**
 * ATTENZIONE: Questa classe non fa parte delle lezioni.
 */

/**
 * Classe di prova per le interfacce funzionali general purpose
 */
public class Snippet {
    public static void main(String[] args) {

        // Interface Function<T,​R>
        // Type Parameters:
        // T - the type of the input to the function
        // R - the type of the result of the function
        Function<Integer, Double> function = (Integer a) -> a * 1.0;
        System.out.println(function.apply(4));

        // Interface Function<T,​R>
        // Type Parameters:
        // T - the type of the input to the function
        // R - the type of the result of the function
        Function<Integer, Double> myFunc = new Function<>() {
            @Override
            public Double apply(Integer integer) {
                return integer * 10.0;
            }
        };

        System.out.println(myFunc.apply(2));

        // Interface Supplier<T>
        // Type Parameters:
        // T - the type of results supplied by this supplier
        Supplier<String> mySupplier = new Supplier<String>() {
            @Override
            public String get() {
                String res = "Success";
                return res;
            }
        };

        System.out.println(mySupplier.get());
    }
}
