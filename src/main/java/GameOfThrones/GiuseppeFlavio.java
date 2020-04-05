package GameOfThrones;

/**
 * Classe ti test per la TavolaRotonda
 */
public class GiuseppeFlavio {
    /**
     * Calcola l'ultimo cavaliere che rimane
     *
     * @param n il numero dei cavalieri iniziali della TavolaRotonda
     * @return un numero intero
     */
    public int ultimo(int n) {
        TavolaRotonda tr = new TavolaRotonda(n);

        while (tr.numeroDiCavalieri() > 1) {

            tr = tr.dopoUscitaCav();
        }

        return tr.cavConLaBrocca();
    }

    /**
     * Calcola l'ultimo cavaliere che rimane
     *
     * @param n il numero dei cavalieri iniziali della TavolaRotonda
     * @return un numero intero
     */
    public int ultimo2(int n) {
        TavolaRotonda2 tr = new TavolaRotonda2(n);

        while (tr.numeroDiCavalieri() > 1) {

            tr = tr.dopoUscitaCav();
        }

        return tr.cavConLaBrocca();
    }

    /**
     * Calcola l'ultimo cavaliere che rimane
     *
     * @param n       il numero dei cavalieri iniziali della TavolaRotonda
     * @param repeats quante volte deve essere ripetuta la procedura ultimo(n)
     * @return un numero intero
     */
    public int test(int n, int repeats) {
        int j = 0;
        long t0 = System.currentTimeMillis(); // start cronometro

        for (int i = 0; i < repeats; i++) {
            j = ultimo2(n);
        }

        long t = System.currentTimeMillis(); // stop cronometro

        System.out.println(t - t0);

        return j;
    }

    public static void main(String[] args) {

        GiuseppeFlavio gv = new GiuseppeFlavio();
        //System.out.println(gv.test(1000, 1));
        System.out.println(gv.test(2000, 1000));
    }
} // GiuseppeFlavio
