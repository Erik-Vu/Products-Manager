import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Class chay chuong trinh
 */
public class OperationToProduct {

    //Phuong thuc lay du lieu tu file noi vao lien ket
    public void getAllItemsFromFile(String fileName, MyList list) {
        File file = new File(fileName);
        ArrayList<String> products = new ArrayList<>();
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                products.add(sc.nextLine()); //Lay du lieu tu file theo dong roi them vao Arrays List
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (String name : products) {
            String[] cutName = name.split(","); //Cat String theo ky tu , roi them vao mang
            Product p = new Product(cutName[0], cutName[1], Integer.parseInt(cutName[2]), Double.parseDouble(cutName[3]));
            list.insert(p);  //them san pham vao list
        }
    }

    //Phuong thuc lay du lieu tu file noi vao Stack
    public void getAllItemsFromFile(String fileName, MyStack list) {
        File file = new File(fileName);
        ArrayList<String> products = new ArrayList<>();
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                products.add(sc.nextLine());
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (String name : products) {
            String[] cutName = name.split(",");
            Product p = new Product(cutName[0], cutName[1], Integer.parseInt(cutName[2]), Double.parseDouble(cutName[3]));
            list.push(p);
        }
    }

    //Phuong thuc lay du lieu tu file noi vao Queue
    public void getAllItemsFromFile(String fileName, MyQueue list) {
        File file = new File(fileName);
        ArrayList<String> products = new ArrayList<>();
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                products.add(sc.nextLine());
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (String name : products) {
            String[] cutName = name.split(",");
            Product p = new Product(cutName[0], cutName[1], Integer.parseInt(cutName[2]), Double.parseDouble(cutName[3]));
            list.enqueue(p);
        }
    }

    //Phuong thuc hien thi san pham trong list
    public void displayAll(MyList list) {
        System.out.printf("\n|%-10s | |%-15s| |%-10s| |%-10s|\n", "ID", "Title", "Quantity", "Price");
        System.out.println("---------------------------------------------------------");
        list.print();
        //Ghi man hinh console vao file
        writeStringToFile("console_output.txt","Choice: 1");
        writeItemsToFile("console_output.txt",list);
    }

    //Hien thi san pham trong stack
    public void displayAll(MyStack stack) {
        System.out.printf("\n|%-10s | |%-15s| |%-10s| |%-10s|\n", "ID", "Title", "Quantity", "Price");
        System.out.println("---------------------------------------------------------");
        stack.print();
        writeStringToFile("console_output.txt","Choice: 9");
        writeItemsToFile("console_output.txt",stack);
    }

    //Hien thi san pham trong queue
    public void displayAll(MyQueue queue) {
        System.out.printf("\n|%-10s | |%-15s| |%-10s| |%-10s|\n", "ID", "Title", "Quantity", "Price");
        System.out.println("---------------------------------------------------------");
        queue.print();
        writeStringToFile("console_output.txt","Choice: 10");
        writeItemsToFile("console_output.txt",queue);
    }

    //Phuong thuc them san pham
    public Product createProduct() {
        Scanner sc = new Scanner(System.in);
        writeStringToFile("console_output.txt","Choice: 2");
        System.out.print("Input new ID: ");
        String id = sc.next();
        writeStringToFile("console_output.txt","Input new ID: " + id);
        System.out.print("Input Product's Name: ");
        String name = sc.next();
        writeStringToFile("console_output.txt","Input Product's Name: " + name);
        System.out.print("Input Product's Quantity: ");
        int quantity = sc.nextInt();
        writeStringToFile("console_output.txt","Input Product's Quantity: " + quantity);
        System.out.print("Input Product's Price: ");
        double price = sc.nextDouble();
        writeStringToFile("console_output.txt","Input Product's Price: " + price);
        System.out.println("\nSuccessfully!\n");
        writeStringToFile("console_output.txt","Successfully!");
        writeStringToFile("console_output.txt","");
        return new Product(id, name, quantity, price);
    }

    //Phuong thuc ghi tat ca lien ket vao file data.txt
    public void writeAllItemsToFile(String fileName, MyList list) {
        File file = new File(fileName);
        String[] arr = list.write();
        try {
            PrintWriter pw = new PrintWriter(file);
            Arrays.stream(arr).forEach(pw::println);
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\nSuccessfully!\n");
        writeStringToFile("console_output.txt","Choice: 4\nSuccessfully!\n");
    }

    // Phuong thuc tim kiem theo id
    public void searchByID(MyList list, String id) {
        System.out.println("\nResult: ");
        System.out.printf("|%-10s | |%-15s| |%-10s| |%-10s|\n", "ID", "Title", "Quantity", "Price");
        ArrayList<Product> products = list.searchID(id);
        System.out.println("\nSuccessfully!\n");
        writeStringToFile("console_output.txt","Choice: 5\nInput the ID to search = "
                + id + "\nResult:\n");
        writeStringToFile("console_output.txt","| ID   | Title   | Quantity   | Price   |");
        writeStringToFile("console_output.txt","-----------------------------------------");
        if (products.isEmpty()) {
            writeStringToFile("console_output.txt","-1");
        }
        else for (Product p: products) {
            writeStringToFile("console_output.txt", p.writeString());
        }
        writeStringToFile("console_output.txt","Successfully\n");
    }

    // Phuong thuc xoa theo id
    public void deleteByID(MyList list, String id) {
        list.checkDelete(id);
        System.out.println("\nDeleted!\n");
        writeStringToFile("console_output.txt","Choice = 6\nInput the ID to delete: "
                + id +"\nDeleted\n");
    }

    // Phuong thuc sap xep theo id
    public void sortByCode(MyList list) {
        list.sortByID();
        System.out.print("\nSuccessfully\n");
        writeStringToFile("console_output.txt","Choice = 7\n Successfully!\n");
    }

    //Phuong thuc chuyen thap phan sang nhi phan dung de quy
    public int convertToBinary(int i) {
        int result, number;
        if (i == 0) result = 0;
        else {
            number = i % 2;
            result = convertToBinary(i / 2) * 10 + number; //De quy ham convertToBinary
        }
        return result;
    }

    //Phuong thuc ghi list vao file console_output.txt
    public void writeItemsToFile(String fileName, MyList list) {
        File file = new File(fileName);
        String[] arr = list.writeOutPut();
        try {
            FileWriter fw = new FileWriter(file,true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("");
            pw.println("| ID   | Title   | Quantity   | Price   |");
            pw.println("------------------------------------------");
            for (String info: arr) pw.println(info);
            pw.println("Successfully!");
            pw.println("");
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Phuong thuc ghi stack vao file console_output.txt
    public void writeItemsToFile(String fileName, MyStack stack) {
        File file = new File(fileName);
        String[] arr = stack.writeOutPut();
        try {
            FileWriter fw = new FileWriter(file,true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("");
            pw.println("| ID   | Title   | Quantity   | Price   |");
            pw.println("------------------------------------------");
            for (String info: arr) pw.println(info);
            pw.println("Successfully!");
            pw.println("");
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Phuong thuc ghi queue vao file console_output.txt
    public void writeItemsToFile(String fileName, MyQueue queue) {
        File file = new File(fileName);
        String[] arr = queue.writeOutPut();
        try {
            FileWriter fw = new FileWriter(file,true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("");
            pw.println("| ID   | Title   | Quantity   | Price   |");
            pw.println("------------------------------------------");
            for (String info: arr) pw.println(info);
            pw.println("Successfully!");
            pw.println("");
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Phuong thuc ghi chuoi String vao file console_output.txt
    public void writeStringToFile(String fileName, String info) {
        File file = new File(fileName);
        try {
            FileWriter fw = new FileWriter(file,true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(info);
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Phuong thuc xoa file console_output.txt de ghi lai tu dau
    public void clearRecord(String fileName) {
        File file = new File(fileName);
        boolean delete = file.delete();
        if (delete) {
            System.out.println("Clear!");
        }
    }
}
