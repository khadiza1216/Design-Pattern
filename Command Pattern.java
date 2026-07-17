// Command Interface
interface Command {
    void execute();
}

// Concrete Command for turning a device ON
class TurnOnCommand implements Command {
    private TV tv;

    public TurnOnCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOn();
    }
}

// Concrete Command for turning a device OFF
class TurnOffCommand implements Command {
    private TV tv;

    public TurnOffCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOff();
    }
}


// Concrete Command for changing TV channel
class ChangeChannelCommand implements Command {
    private TV tv;

    public ChangeChannelCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.changeChannel();
    }
}

// Receiver Interface

// Concrete Receiver: TV
class TV  {
    
    public void turnOn() {
        System.out.println("TV is now on");
    }


    public void turnOff() {
        System.out.println("TV is now off");
    }

    public void changeChannel() {
        System.out.println("Channel changed");
    }
}



// Invoker
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        if (command != null) {
            command.execute();
        } else {
            System.out.println("No command assigned");
        }
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {

        // Create receivers
        TV tv = new TV();
        

        // Create commands
        Command turnOnTV = new TurnOnCommand(tv);
        Command turnOffTV = new TurnOffCommand(tv);
    
        Command changeChannel = new ChangeChannelCommand(tv);

        // Create invoker
        RemoteControl remote = new RemoteControl();

        // Execute commands
        remote.setCommand(turnOnTV);
        remote.pressButton();

        
        remote.pressButton();

        remote.setCommand(changeChannel);
        remote.pressButton();

        remote.setCommand(turnOffTV);
        remote.pressButton();
    }
}