interface device {
   void turnon();
   void turnoff(); 
}

class tv implements device{
@Override
public void turnon(){
    System.out.println("tv turned on");
}
@Override
public void turnoff(){
    System.out.println("tv turned off");
}

}


interface command{
    void execute();

}

class turnoncommand implements command{
  device device;

  turnoncommand(device device){
    this.device=device;
  }
  @Override
  public void execute(){
    device.turnon();
  }

}

class turnoffcommand implements command{
  device device;

  turnoffcommand(device device){
    this.device=device;
  }
  @Override
  public void execute(){
    device.turnoff();
  }

}

public class remote {
    command command;
    void remote(command command){
        this.command=command;
    }

    void pressbutton(){
        if(command!=null){
            command.execute();
        }else{
            System.out.println("no command assigned");
        }
    }
}

import java.util.Scanner;
 class main {

    public static void main(String[] args){
        device tv=new tv();

        Scanner sc= new Scanner(System.in);

        System.out.println("1. turn on tv");
        System.out.println("2. turn off tv");

        int choice= sc.nextInt();


        command on= new turnoncommand(tv);
        command off= new turnoffcommand(tv);

        remote r= new remote();
        
        if(choice==1){
        r.remote(on);
        r.pressbutton();
        }
        else if (choice==2){
        r.remote(off);
        r.pressbutton();
        }

        else{
            System.out.println("invalid choice");
        }
    }
}
