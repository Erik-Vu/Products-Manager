/**
 * Class tao lien ket Queue
 */
public class MyQueue {
    private Node head,tail;

    public MyQueue() {
        head = tail = null;
    }

    //Them Node vao queue
    public void enqueue(Product p) {
        Node newNode = new Node(p);
        if (head == null) {
            head = newNode;
        }
        else {
            tail.setNext(newNode);
        }
        tail = newNode;
    }

    //In thong tin chuoi queue ra man hinh
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.printf("|%-10s | |%-15s| |%-10s| |%-10s|\n",current.getInfo().getId(), current.getInfo().getTitle(), current.getInfo().getQuantity(),current.getInfo().getPrice());
            current = current.getNext();
        }
        System.out.println("Successfully!");
    }

    //Tra ve do dai chuoi lien ket
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
