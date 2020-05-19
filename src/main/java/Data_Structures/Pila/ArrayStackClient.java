package Data_Structures.Pila;

/**
 * Esempio di utilizzo per la classe ArrayStack<E>
 */
public class ArrayStackClient {
    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack<>();
        System.out.printf("%s\n", stack); // ()
        System.out.printf("%s\n", stack.isEmpty()); // true
        stack.push(5);
        stack.push(8);
        stack.push(4);
        stack.push(9);
        stack.push(3);
        stack.push(5);
        stack.push(7);
        stack.push(2);
        System.out.printf("%s\n", stack); // (5, 8, 4, 9, 3, 5, 7, 2)
        System.out.printf("%d\n", stack.size()); // 8
        System.out.printf("%d\n", stack.top()); // 2
        System.out.printf("%s\n", stack.isEmpty()); // false
        System.out.printf("%d\n", stack.pop()); // 2
        System.out.printf("%s\n", stack); // (5, 8, 4, 9, 3, 5, 7)
    }
}
