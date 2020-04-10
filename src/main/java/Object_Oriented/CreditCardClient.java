package Object_Oriented;

public class CreditCardClient {
    public static void main(String[] args) {

        CreditCard creditCard = new CreditCard("Alessandro Bowman", "Deutsche Bank Italia", "5391 0375 9387 8309", 3000, 1250);

        CreditCard.printSummary(creditCard);
        creditCard.charge(100);
        System.out.println("New balance = " + creditCard.getBalance()); // 1350.0
        creditCard.makePayment(350);
        System.out.println("New balance = " + creditCard.getBalance()); // 1000.0
    }
}
