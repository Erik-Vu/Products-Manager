/**
 * Class tao Node
 * Phuong thuc khoi tao, getter, setter
 */

public class Node {
    private Product info;
    private Node next;

    public Node() {
    }

    public Node(Product info) {
        this.info = info;
    }

    public Product getInfo() {
        return info;
    }

    public void setInfo(Product info) {
        this.info = info;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
