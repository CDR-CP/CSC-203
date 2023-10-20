import java.util.ArrayList;
import java.util.Collections;

public class LinkedList {

    public Node head;

    public LinkedList(Node head) {
        this.head = head;
    }

    public void add(int data) {
        this.head = new Node(data, this.head);
    }

    public int getLength() {
        int count = 0;
        Node current = this.head;

        while (current != null) {
            current = current.next;
            count++;
        }

        return count;
    }

    @Override
    public String toString() {
        if (this.head == null) {
            return "0"; // Handle the case of an empty linked list as 0
        } else {
            StringBuilder sb = new StringBuilder();
            Node current = this.head;

            while (current != null) {
                sb.append(current.value);
                current = current.next;
            }

            return sb.toString();
        }
    }
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

}
