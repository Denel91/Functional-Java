package Laboratorio.Torri_di_Hanoi;

public class TowersOfHanoiDemo {
    public static void main(String[] args) {
        final int NDISKS = 5;
        Towers_Of_Hanoi towers_of_hanoi = new Towers_Of_Hanoi(NDISKS);
        towers_of_hanoi.move(5, 0, 2);
    }
}
