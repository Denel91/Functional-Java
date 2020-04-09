package Java_Util_Function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.BiFunction;

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

        List<Integer> list = new ArrayList<Integer>();
        list.add(4);
        list.add(3);
        list.add(6);
        list.add(5);
        list.add(1);
        list.add(2);

        list = map(list, x -> x * 2);
        System.out.print("Map: ");
        for (Integer val : list)
            System.out.print(val + " ");

        list = filter(list, x -> x >= 0);
        System.out.print("Filter: ");
        for (Integer val : list)
            System.out.print(val + " ");

        System.out.println("Reduce: ");
        int sum = reduce(list, (a, b) -> a + b, 0);
        System.out.println("sum: " + sum);

        double positivo = 5.0;
        double negativo = -5.0;
        double zero = 0.0;
        double zeroNegative = -0.0;

        System.out.println("positive: " + Math.signum(positivo)); // 1.0
        System.out.println("negative: " + Math.signum(negativo)); // -1.0
        System.out.println("zero: " + Math.signum(zero)); // 0.0
        System.out.println("zeroNegative: " + Math.signum(zeroNegative)); // -0.0
    }

    static <T> List<T> map(List<T> list, Function<T, T> function) {
        List<T> mappedList = new ArrayList<T>(list);
        for (int i = 0; i < mappedList.size(); i++) {
            mappedList.set(i, function.apply(mappedList.get(i)));
        }

        return mappedList;
    }

    static <T, R> List<T> filter(List<T> list, Function<T, R> function) {
        List<T> filteredList = new ArrayList<T>();
        for (T element : list) {
            if ((boolean) function.apply(element)) {
                filteredList.add(element);
            }
        }

        return filteredList;
    }

    static <T> T reduce(List<T> list, BiFunction<T, T, T> function, T initial) {
        T accumulator = initial;
        for (T element : list) {
            accumulator = function.apply(accumulator, element);
        }

        return accumulator;
    }
}
