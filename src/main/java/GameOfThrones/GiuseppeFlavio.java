package GameOfThrones;

public class GiuseppeFlavio {

    public int ultimo(int n) {
        TavolaRotonda tr = new TavolaRotonda(n);

        while (tr.numeroDiCavalieri() > 1) {

            tr = tr.dopoUscitaCav();
        }

        return tr.cavConLaBrocca();
    }

    public int test(int n, int repeats) {
        int j = 0;
        long t0 = System.currentTimeMillis(); // start cronometro

        for (int i = 0; i < repeats; i++) {
            j = ultimo(n);
        }

        long t = System.currentTimeMillis(); // stop cronometro

        System.out.println(t - t0);

        return j;
    }

    public static void main(String[] args) {

        GiuseppeFlavio gv = new GiuseppeFlavio();
        System.out.println( gv.test(1000, 1));
    }
} // GiuseppeFlavio
