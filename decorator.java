import java.util.Scanner;
//component
interface coffee{
    double getCost();
    String getDescription();
}

class basiccoffee implements coffee{
    public double getCost(){
        return 2.00;
    }
    public String getDescription(){
        return "Simple black coffee";
    }

}

//decorator class
abstract class decorator implements coffee {

    protected coffee coffee;

    decorator(coffee coffee) {
        this.coffee = coffee;
    }

    public String getDescription() {
        return coffee.getDescription();
    }

    public double getCost() {
        return coffee.getCost();
    }
}

// Concrete Decorator 1
class Milk extends decorator {

    Milk(coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " + Milk";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 30;
    }
}

// Concrete Decorator 2
class Sugar extends decorator {

    Sugar(coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " + Sugar";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 10;
    }
}




 class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        coffee coffee = new basiccoffee();

        System.out.println("1. Add Milk");
        System.out.println("2. Add Sugar");
        System.out.println("3. Add Milk and Sugar");

        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        if (choice == 1) {

            coffee = new Milk(coffee);

        } else if (choice == 2) {

            coffee = new Sugar(coffee);

        } else if (choice == 3) {

            coffee = new Milk(coffee);
            coffee = new Sugar(coffee);

        } else {

            System.out.println("Invalid choice.");
        }

        System.out.println("\nCoffee: " + coffee.getDescription());
        System.out.println("Total Cost: £" + coffee.getCost());

        
    }
}
