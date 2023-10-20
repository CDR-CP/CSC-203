package LinkedListCode;

import java.util.ArrayList;

public class LinkedList {

   public node head;

   public LinkedList(node head) {
       this.head = head;
   }

    public void add(int data) {
       this.head = new node(data, this.head);
    }

    public int getLength() {
       // returns the length of the given linked list, called LinkedListName.getLength()
        int count = 0;
        node current = this.head;

        while (current.next != null) {
            current = current.next;
            count++;
        }

        return count;
    }

    public String toString() { // toString override
        if (this.head == null) {
            // if the list is empty, return an empty string
            return "";
        }

        else if (this.head.next == null) {
            // if there is 1 item, return a string of the value
            return Integer.toString(this.head.value);
        }

        // if length > 1, create a new arraylist, append every value to it, and return the reversed list as a string
        ArrayList<Integer> numberStr = new ArrayList<>();
        node current = this.head;

        while (current.next != null) {
            numberStr.add(current.value);
            current = current.next;
        }

        return numberStr.reversed().toString();
    }

}