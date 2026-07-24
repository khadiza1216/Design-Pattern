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
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        s1.display();
        if(s1==s2){
            System.out.println("both are same");
        }
        else{
            System.out.println("both are not same");
        }
    }
}
