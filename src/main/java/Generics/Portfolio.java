package Generics;

public class Portfolio<T> {
    T[] data;

    public Portfolio(int capacity) {
        data = (T[]) new Object[capacity];
    }

    public T getData(int index) {
        return data[index];
    }

    public void setData(int index, T element) {
        data[index] = element;
    }
}
