import java.util.Scanner;

class MultiplicationTable  extends Thread{
    public void run()
    {
        Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the number for multiplication table: ");
    int num = scanner.nextInt();
    System.out.println("Multiplication table for " + num + ":");
    for (int i = 1; i <= 10; i++) {
        System.out.println(num + " x " + i + " = " + (num * i));
    }
}
}
class AdditionTable extends Thread{
     public void run()
    {
         Scanner scanner = new Scanner(System.in);
    System.out.println(" ENTER THE NUMBER FOR ADDITION");
    int num1 = scanner.nextInt();
    System.out.println("ADDITION"+num1);
    for(int i=1;i<=10;i++)
    {
        System.out.println(num1+"+"+i+"="+(num1+i));
    }
}
}
public class LAB7 {
    public static void main(String[] args) {
        System.out.println(".(ENTER )");
        MultiplicationTable m = new MultiplicationTable();
        AdditionTable a = new AdditionTable();
        m.start();
        a.start();
    }
}
