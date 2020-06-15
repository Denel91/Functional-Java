package Dynamic_programming;

import static Dynamic_programming.Llcs.llcs;

public class ExamExercise {
    public static String migliore(String w, String[] ws) {

        int n = ws.length;
        int y = llcs(ws[0], w);
        int k = 0;

        for (int i = 0; i < n; i++) {
            int x = llcs(ws[i], w);
            if (x > y) {
                y = x;
                k = i;
            }
        }

        return ws[k];
    }

    public static void main(String[] args) {
        String w = "saturno";
        String[] ws = {"saturnia", "saturno", "salerno"};
        String result = migliore(w, ws);
        System.out.println(result);
    }
}
