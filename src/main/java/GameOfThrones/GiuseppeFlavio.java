package GameOfThrones;

public class GiuseppeFlavio {

    public int ultimo(int n) {
        TavolaRotonda tr = new TavolaRotonda(n);

        while (tr.numeroDiCavalieri() > 1) {

            tr = tr.dopoUscitaCav();
        }

        return tr.cavConLaBrocca();
    }
} // GiuseppeFlavio
