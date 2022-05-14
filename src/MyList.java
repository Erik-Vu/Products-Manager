import java.util.ArrayList;

/**
 * Class quan ly Linked Link
 * Phuong thuc khoi tao, getter, setter
 */

public class MyList {
    private Node head,tail;

    public MyList() {
    }

    public MyList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    public boolean isEmpty() {
        return head == null;
    }
    /*
    Phuong thuc xoa lien ket
    */
    public void clear() {
        head = tail = null;
    }

    //Phuong thuc do do dai chuoi lien ket
    public int length() {
        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.getNext();
        }
        return length;
    }

    //Phuong thuc them Node moi vao cuoi chuoi
    public void insert(Product p) {
        Node newNode = new Node(p);
        if (head == null) {
            head = newNode;
        }
        else {
            tail.setNext(newNode);
        }
        tail = newNode;
    }

    //Phuong thuc in ra man hinh console thong tin chuoi
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.printf("|%-10s | |%-15s| |%-10s| |%-10s|\n",current.getInfo().getId(), current.getInfo().getTitle(), current.getInfo().getQuantity(),current.getInfo().getPrice());
            current = current.getNext();
        }
        System.out.println("Successfully!");
    }

    //Phuong thuc lay ra mang String thong tin san pham
    public String[] write() {
        String[] arr = new String[length()];
        int i = 0;
        Node current = head;
        while (current != null) {
            arr[i] = current.getInfo().toString();
            i++;
            current = current.getNext();
        }
        return arr;
    }

    //Phuong thuc lay ra mang String thong tin san pham ghi vao console_output.txt
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

    //Phuong thuc tim kiem san pham theo id
    public ArrayList<Product> searchID(String id) {
        Node current = head;
        boolean zero = true;
        ArrayList<Product> products = new ArrayList<>();
        while (current != null) {
            if (current.getInfo().getId().contains(id)) {
                System.out.printf("|%-10s | |%-15s| |%-10s| |%-10s|\n",current.getInfo().getId()
                        , current.getInfo().getTitle(), current.getInfo().getQuantity(),current.getInfo().getPrice());
                zero = false;
                products.add(current.getInfo());
            }
            current = current.getNext();
        }
        if (zero) System.out.println("-1");
        return products;
    }

    //Phuong thuc xoa san pham theo id
    public void deleteID(String id) {
        Node current = head;  //Tao node hien tai
        Node prevent = null;  //Tao node tro vao node hien tai
        if (current != null && current.getInfo().getId().equalsIgnoreCase(id)) {
            head = current.getNext();   //id cua head bang id can xoa thi tro head den node tiep theo
            return;
        }
        while (current != null && !current.getInfo().getId().equalsIgnoreCase(id)) {
            prevent = current;    //node truoc luu vao hien tai
            current = current.getNext(); // node hien tai luu vao node tiep theo
        }
        if (current == null) return; // ca chuoi khong co id nao trung voi id can xoa
        assert prevent != null;
        prevent.setNext(current.getNext()); //set con tro cua node truoc node can xoa vao node sau not can xoa
    }

    // Phuong thuc kiem ra xem con san pham can xoa khong
    public void checkDelete(String id) {
        Node current = head;
        while (current != null) {
            if ( current.getInfo().getId().equalsIgnoreCase(id)) {
                deleteID(id);  // Xoa tat ca node co id can xoa
            }
            current = current.getNext();
        }
    }

    //Phuong thuc tra ve dem chot cua quickSort
    public int partition(Product[] p, int low, int high) {
        Product pivot = p[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (p[j].getId().compareTo(pivot.getId()) < 0) {
                i++;
                Product temp = p[i];
                p[i] = p[j];
                p[j] = temp;
            }
        }
        Product temp = p[i + 1];
        p[i + 1] = p[high];
        p[high] = temp;
        return i + 1;
    }

    //Phuong thuc sap xep id theo quickSort
    public void quickSort(Product[] p, int low, int high) {
        if ( low < high) {
            int pi = partition(p,low,high);
            quickSort(p,low,pi - 1); //De quy chuoi ben trai
            quickSort(p,pi + 1, high); // De quy chuoi ban phai
        }
    }

    //Phuong thuc tra lai lien ket sau khi sap xep
    public void sortByID() {
        Node current = head;
        Product[] products = new Product[length()];
        int i = 0;
        while (current != null) {
            products[i] = current.getInfo(); //Lay du lieu cua link list gan vao mang san pham
            current = current.getNext();
            i++;
        }
        quickSort(products,0,length() - 1); //Dung quick sort sap xep mang san pham
        clear(); // Xoa lien ket chuoi
        for (Product p: products) {
            insert(p); // Tao lien ket moi theo mang da sap xep
        }
    }

    //Phuong thuc lay ra gia tri Quantity cua head
    public int getQuantity() {
        Node current = head;
        return current.getInfo().getQuantity();
    }

}
