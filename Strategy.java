// Strategy Interface
interface Payment {
    void pay(int amount);
}

// Concrete Strategy 1
class CreditCardPayment implements Payment {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

// Concrete Strategy 2
class BkashPayment implements Payment {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Bkash");
    }
}

// Context
class ShoppingCart {
    private Payment payment;

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void checkout(int amount) {
        payment.pay(amount);
    }
}

// Main
public class Strategy {
    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();
        CreditCardPayment creditCardPayment = new CreditCardPayment();
        cart.setPayment(creditCardPayment);
        cart.checkout(1000);

        BkashPayment bkashPayment = new BkashPayment();
        cart.setPayment(bkashPayment);
        cart.checkout(500);
    }
}