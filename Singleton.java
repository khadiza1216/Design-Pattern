class Singleton {
    // Create the single instance eagerly
    private static Singleton instance;
    // Private constructor prevents object creation
    private Singleton() {
        System.out.println("Singleton is Instantiated."); 
}
    // Global access method
    public static Singleton getInstance() {
        if (instance == null)
            instance = new Singleton();
        return instance;
    }
    public void display() {
        System.out.println("Singleton instance");
    }
}
public class Main {
    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

        System.out.println(obj1 == obj2); // true
    }
}
