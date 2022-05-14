/**
 * Class tao lien ket Stack
 */
public class MyStack {
    private Node head;

    public MyStack() {
        head = null;
    }

    //Phuong thuc them Node vao stack
    public void push(Product p) {
        Node newNode = new Node(p);
        newNode.setNext(head);
        head = newNode;
    }

    //Phuong thuc in thong tin chuoi ra man hinh
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.printf("|%-10s | |%-15s| |%-10s| |%-10s|\n",current.getInfo().getId()
                    , current.getInfo().getTitle(), current.getInfo().getQuantity(),current.getInfo().getPrice());
            current = current.getNext();
        }
        System.out.println("Successfully!");
    }

    //Phuong thuc tra ve do dai chuoi
    public int length() {
        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.getNext();
        }
        return length;
    }

    //Tra ve mang String de ghi vao file console_output.txt
    public String[] writeOutPut() {
        String[] arr = new String[length()];
        int i = 0;
        Node current = head;
        while (current != null) {
            arr[i] = current.getInfo().writeString();
            i++;
            current = current.getNext();
        }
        return arr;
    }

}
