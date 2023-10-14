package LinkedListCode;

public class LinkedList {

   Node head; // Default access modifier is package-private 

    class Node {
        int value;
        Node next;
        // Node class
        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList() {
        head = null; // Initializes head in LinkedList
    }

    public void addValue(int value) { // Adds value to LinkedList
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public String toString() { // Constructor
        if (head == null) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        Node current = head;
        while (current != null) {
            result.insert(0, current.value);
            current = current.next;
        }

        return result.toString().replaceFirst("^0+(?!$)", ""); // Kill the leading zeros
    }

}