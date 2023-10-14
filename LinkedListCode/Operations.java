package LinkedListCode;

public class Operations {
    public static LinkedList add(LinkedList num1, LinkedList num2) {

        LinkedList result = new LinkedList();
        LinkedList.Node current1 = num1.head;
        LinkedList.Node current2 = num2.head;
        int carry = 0;

        while (current1 != null || current2 != null) {
            int value1 = (current1 != null) ? current1.value : 0;
            int value2 = (current2 != null) ? current2.value : 0;
            int sum = value1 + value2 + carry;
            carry = sum / 10;
            result.addValue(sum % 10);

            if (current1 != null) current1 = current1.next;
            if (current2 != null) current2 = current2.next;
        }

        if (carry > 0) {
            result.addValue(carry);
        }

        return result;
        //
    }

    public static LinkedList subtract(LinkedList num1, LinkedList num2) {
        return null;
        //
    }

    public static LinkedList multiply(LinkedList num1, LinkedList num2) {
        return null;
        //
    }

    public static LinkedList divide(LinkedList dividend, LinkedList divisor) {

        //
        return null;
    }

    public static LinkedList exponentiate(LinkedList base, LinkedList exponent) {
        return null;
        //
    }
}
