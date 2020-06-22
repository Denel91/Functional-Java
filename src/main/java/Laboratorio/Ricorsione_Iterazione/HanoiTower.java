package Laboratorio.Ricorsione_Iterazione;

import java.util.Stack;

public class HanoiTower {

    public static String hanoiMoves(int n) {
        return hanoiRec(n, 1, 2, 3);
    }

    private static String hanoiRec(int n, int s, int d, int t) {
        if (n == 1) {
            return (" " + s + "->" + d);
        } else {
            String m1 = hanoiRec(n - 1, s, t, d);
            String m2 = hanoiRec(n - 1, t, d, s);
            return (m1 + " " + s + "->" + d + m2);
        }
    }

    public static String hanoiMovesIter(int n) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{n, 1, 2, 3});
        String moves = "";
        int s, d, t;
        while (!stack.isEmpty()) {
            int[] args = stack.pop();
            n = args[0];
            s = args[1];
            d = args[2];
            t = args[3];
            if (n == 1) {
                moves = moves + " " + s + "->" + d;
            } else {
                stack.push(new int[]{n - 1, t, d, s});
                stack.push(new int[]{1, s, d, t});
                stack.push(new int[]{n - 1, s, t, d});
            }
        }

        return moves;
    }

    public static void main(String[] args) {
        System.out.println(hanoiMovesIter(2));
    }
}
