
import com.order.OrderManagement;

import java.util.Scanner;

public class Start {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Boolean isToContinue=true;
        while (isToContinue)
        {
            showOptions();
            int opt=scanner.nextInt();
            isToContinue=performTask(opt, true);
        }
    }

    private static void showOptions() {
        System.out.println("******** Welcome to Coffee Shop********");
        System.out.println("1.Show the drinks menu");
        System.out.println("2.Add drink to order");
        System.out.println("3.Remove the drink from the order");
        System.out.println("4.Place an order");
        System.out.println("5.Exit");
        System.out.println("6.Show Order History");
        System.out.print("Enter your choice (1-5):");
    }

    private static Boolean performTask(int opt, Boolean isToContinue) {
        switch (opt) {
            case 1:
                OrderManagement.showMenu();
                break;
            case 2:
                OrderManagement.addDrink(scanner);
                break;
            case 3:
                OrderManagement.removeDrink(scanner);
                break;
            case 4:
                OrderManagement.placeOrder(scanner);
                 isToContinue=isToContinue();
                break;
            case 5:
                isToContinue=false;
                break;
            case 6:
                OrderManagement.showHistory(scanner);
                break;
        }
        return isToContinue;
    }

    private static boolean isToContinue() {
        boolean isToPerformTask;
        System.out.print("Do you want to continue?(yes/no):");
        String contiue =scanner.next();

        if(contiue.equals("yes"))
        {
            isToPerformTask=true;
        }else {
            isToPerformTask=false;
        }
        return isToPerformTask;
    }
}
