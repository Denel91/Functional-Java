package Data_Structures.Pila;

public class LinkedStackClient {
    public static void main(String[] args) {
        LinkedStack<Integer> stack = new LinkedStack<>();
        System.out.println(stack); // ()

        stack.push(5);
        stack.push(3);
        stack.push(8);
        stack.push(4);
        stack.push(7);
        stack.push(9);

        System.out.println(stack); // (9, 7, 4, 8, 3, 5)
        System.out.println(stack.size()); // 6
        System.out.println(stack.isEmpty()); // false
        System.out.println(stack.top()); // 9
        System.out.println(stack.pop()); // 9
        System.out.println(stack); // (7, 4, 8, 3, 5)
    }
}
