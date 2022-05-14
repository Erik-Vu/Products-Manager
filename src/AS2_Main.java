import java.util.Scanner;

/**
 * Class chay chuong trinh
 */

public class AS2_Main {
    //Ham in thong tin menu ra man hinh
    public static void showMenu() {
        System.out.println("\n******************************************");
        System.out.println("* Choose one of this options:            *");
        System.out.println("* Product list:                          *");
        System.out.println("* 1. Load data from file and display.    *");
        System.out.println("* 2. Input & add to the end.             *");
        System.out.println("* 3. Display data.                       *");
        System.out.println("* 4. Save product list to file.          *");
        System.out.println("* 5. Search by ID.                       *");
        System.out.println("* 6. Delete by ID.                       *");
        System.out.println("* 7. Sort by ID.                         *");
        System.out.println("* 8. Convert to Binary.                  *");
        System.out.println("* 9. Load to stack and display.          *");
        System.out.println("* 10. Load to queue and display.         *");
        System.out.println("* 11. Clear record.                      *");
        System.out.println("* 0.Exit                                 *");
        System.out.println("******************************************");
        System.out.print("Choice: ");
    }

    //Ham main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean run = true;
        OperationToProduct open = new OperationToProduct();
        MyList list = new MyList();
        MyStack stack = new MyStack();
        MyQueue queue = new MyQueue();
        do {
            showMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    open.getAllItemsFromFile("data.txt",list);
                    open.displayAll(list);
                }
                case 2 -> list.insert(open.createProduct());
                case 3 -> {
                    System.out.printf("\n|%-10s | |%-15s| |%-10s| |%-10s|\n","ID","Title","Quantity", "Price");
                    System.out.println("---------------------------------------------------------");
                    list.print();
                    open.writeStringToFile("console_output.txt","Choice: 3");
                    open.writeItemsToFile("console_output.txt",list);
                }
                case 4 -> open.writeAllItemsToFile("data.txt",list);
                case 5 -> {
                    System.out.print("Input the ID to search: ");
                    String id = sc.next();
                    open.searchByID(list,id);
                }
                case 6 -> {
                    System.out.print("Input the ID to delete: ");
                    String id = sc.next();
                    open.deleteByID(list,id);
                }
                case 7 -> open.sortByCode(list);
                case 8 -> {
                    System.out.print("Quantity = " + list.getQuantity());
                    int result = open.convertToBinary(list.getQuantity());
                    System.out.print(" => (" + result + ")\n");
                    open.writeStringToFile("console_output.txt","Choice 8: \nQuantity = "
                            + list.getQuantity() + " => (" + result + ")\n");
                }
                case 9 -> {
                    open.getAllItemsFromFile("data.txt",stack);
                    open.displayAll(stack);
                }
                case 10 -> {
                    open.getAllItemsFromFile("data.txt",queue);
                    open.displayAll(queue);
                }
                case 11 -> open.clearRecord("console_output.txt");
                case 0 -> run = false;
                default -> System.out.println("No option. Please try again!");
            }
        } while (run);
    }
}
