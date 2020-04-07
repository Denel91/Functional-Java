package Laboratorio.Codifica_in_Java;

import Liste.StringSList;

/**
 * Esercitazione sulla codifica in Java
 *
 * @version 07/04/2020
 */
public class CodSchemeToJava {
    public static void main(String[] args) {
        System.out.println(ones_complement("1010")); // 0101
        System.out.println(bit_complement("1")); // 0
        System.out.println(bit_complement("0")); // 1
        System.out.println(btr("++")); // +--
        StringSList list = STB("+-", 5);
        System.out.println(list.toString()); // (+-, +., ++, +--, +-.)
        System.out.println(btrSucc("+-")); // +.
    }

    /**
     * Complemento a uno di una stringa
     * Versione ricorsiva
     *
     * @param bin the string to be encoded
     * @return a new String
     */
    public static String ones_complement(String bin) {
        int n = bin.length();
        if (bin.equals("")) {
            return "";
        } else {
            return ones_complement(bin.substring(0, n - 1)) + bit_complement(bin.substring(n - 1));
        }
    }

    /**
     * Complemento a uno di una stringa
     * Versione iterativa
     * La stringa passata deve avere la forma "10010"
     *
     * @param bin the string to be encoded
     * @return a new String
     */

    /*
    public static String ones_complement(String bin) {
        int length = bin.length();
        // restituisce un array di char contenente tutti i caratteri della stringa.
        char[] s = bin.toCharArray();

        if (bin.equals("")) {
            return "";
        }

        for (int i = 0; i < length; i++) {
            if (s[i] == '0') {
                s[i] = '1';
            } else {
                s[i] = '0';
            }
        }

        // public String(char[] value): crea una stringa con i caratteri contenuti nell'array value.
        return new String(s);
    }
    */

    /**
     * Complemento del singolo bit
     *
     * @param bit a single bit -> "1" or "0"
     * @return "1" or "0"
     */
    public static String bit_complement(String bit) {
        if (bit.equals("0")) {
            return "1";
        } else {
            return "0";
        }
    }

    /**
     * Rappresentazione Ternaria Bilanciata
     *
     * @param valore stringa di -/./+ -> valore = "-.+"
     * @return a string with + . or -
     */
    public static String btr(String valore) {
        int n = valore.length();
        char carattere = valore.charAt(n - 1);
        String sub = valore.substring(0, n - 1);
        if (n == 1) {
            if (carattere == '+') {
                return "+-";
            } else if (carattere == '.') {
                return "+";
            } else {
                return ".";
            }
        } else {
            if (carattere == '+') {
                return btr(sub) + '-';
            } else {
                if (carattere == '-') {
                    return sub + '.';
                } else {
                    return sub + '+';
                }
            }
        }
    }

    /**
     * Rappresentazione Ternaria Bilanciata Ricorsiva
     *
     * @param valore stringa di -/./+ -> valore = "-.+"
     * @param n      dimensione della lista
     * @return a new StringSList
     */
    public static StringSList STB(String valore, int n) {
        if (n <= 0) {
            return new StringSList();
        } else {
            return new StringSList(valore, STB(CodSchemeToJava.btr(valore), n - 1));
        }
    }

    /**
     * Rappresentazione Ternaria Bilanciata del btr successivo
     *
     * @param s stringa di -/./+ -> s = "-.+"
     * @return a string with + . or -
     */
    public static String btrSucc(String s) {
        int valore = s.length();

        if (valore == 1) {
            if (s.charAt(valore - 1) == '+') {
                return "+-";
            } else if (s.charAt(valore - 1) == '.') {
                return "+";
            } else {
                return ".";
            }

        } else {

            if (s.charAt(valore - 1) == '+') {
                return btrSucc(s.substring(0, valore - 1)) + "-";
            } else if (s.charAt(valore - 1) == '-') {
                return s.substring(0, valore - 1) + ".";
            } else {
                return s.substring(0, valore - 1) + "+";
            }
        }
    }
}
