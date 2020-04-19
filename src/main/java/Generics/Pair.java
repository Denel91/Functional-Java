package Generics;

/**
 * Definizione di una coppia usando parametri di tipo generici
 */
public class Pair<A, B> {
    A first;
    B second;

    public Pair(A a, B b) {
        this.first  = a;
        this.second = b;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    public void setFirst(A first) {
        this.first = first;
    }

    public void setSecond(B second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "Pair {" + "first = " + first + ", second = " + second + '}';
    }

    public static void main(String[] args) {
        Pair<String, Double> bid = new Pair<>("Book", 35.12);
        Pair<String, Double>[] holdings = new Pair[10];
        holdings[0] = new Pair<>("orlc", 22.12 );
        System.out.println(holdings.length); // 10
        System.out.println(bid.toString()); // Pair {first = Book, second = 35.12}
    }
}
