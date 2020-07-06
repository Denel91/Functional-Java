package Laboratorio.Abstract_Data_Type;

/**
 * Classe Counter
 */
public class Counter {
    private int value;

    public Counter() {
        this.value = 0;
    }

    public Counter(int k) {
        this.value = k;
    }

    public void reset() {
        value = 0;
    }

    public void increase() {
        value++;
    }

    public void decrease() {
        value--;
    }

    public void inc(int k) {
        value += k;
    }

    public void dec(int k) {
        value -= k;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        counter.increase();
        System.out.println(counter); // 1
        counter.inc(5);
        System.out.println(counter); // 6
        counter.dec(3);
        System.out.println(counter); // 3
        counter.decrease();
        System.out.println(counter); // 2

        Counter counter1 = new Counter(4);
        counter1.increase();
        System.out.println(counter1); // 5
    }
}
