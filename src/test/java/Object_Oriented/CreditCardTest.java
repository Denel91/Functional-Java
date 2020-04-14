package Object_Oriented;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class Test
 */
class CreditCardTest {

    CreditCard card;

    @Test
    @DisplayName("newCard")
    void newCard() {
        new CreditCard("John Bowman", "Deutsche Bank", "5891 0375 9387 6308", 3000, 0.0);
    }

    @Nested
    @DisplayName("Class afterNewCard")
    class afterNewCard {

        Integer limit = 3000;
        Double balance = 1000.00;

        // Executed before each @Test
        @BeforeEach
        void newCreditCard() {
            card = new CreditCard("John Bowman", "Deutsche Bank", "5891 0375 9387 6308", limit, balance);
        }

        @Test
        @DisplayName("Customer")
        void getCustomer() {
            assertEquals("John Bowman", card.getCustomer());
        }

        @Test
        @DisplayName("Bank")
        void getBank() {
            assertEquals("Deutsche Bank", card.getBank());
        }

        @Test
        @DisplayName("Account")
        void getAccount() {
            assertEquals("5891 0375 9387 6308", card.getAccount());
        }

        @Test
        @DisplayName("Limit")
        void getLimit() {
            assertEquals(limit, card.getLimit());
        }

        @Test
        @DisplayName("Balance")
        void getBalance() {
            assertEquals(balance, card.getBalance());
        }

        @Test
        @DisplayName("Addebito")
        void charge() {
            assertTrue(card.charge(400.00), () -> "Addebitato");
            assertEquals(1400.00, card.getBalance());
        }

        @Test
        @DisplayName("Payment")
        void makePayment() {
            card.makePayment(200.00);
            assertEquals(800.00, card.getBalance());
        }
    }
}