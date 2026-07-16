// Handler Interface
interface SupportHandler {
    void setNext(SupportHandler next);
    void handle(String issue);
}

// Level 1
class Level1 implements SupportHandler {
    private SupportHandler next;

    public void setNext(SupportHandler next) {
        this.next = next;
    }

    public void handle(String issue) {
        if (issue.equals("Basic")) {
            System.out.println("Level 1 handled the request.");
        } else if (next != null) {
            next.handle(issue);
        }
    }
}

// Level 2
class Level2 implements SupportHandler {
    private SupportHandler next;

    public void setNext(SupportHandler next) {
        this.next = next;
    }

    public void handle(String issue) {
        if (issue.equals("Intermediate")) {
            System.out.println("Level 2 handled the request.");
        } else if (next != null) {
            next.handle(issue);
        }
    }
}

// Level 3
class Level3 implements SupportHandler {

    public void setNext(SupportHandler next) {
        // No next handler
    }

    public void handle(String issue) {
        if (issue.equals("Critical")) {
            System.out.println("Level 3 handled the request.");
        } else {
            System.out.println("Request cannot be handled.");
        }
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {

        SupportHandler l1 = new Level1();
        SupportHandler l2 = new Level2();
        SupportHandler l3 = new Level3();

        l1.setNext(l2);
        l2.setNext(l3);

        l1.handle("Basic");
        l1.handle("Intermediate");
        l1.handle("Critical");
        l1.handle("Other");
    }
}