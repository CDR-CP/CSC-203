public class Operations {
    public static LinkedList add(LinkedList num1, LinkedList num2) {
        LinkedList result = new LinkedList(null);
        Node current1 = num1.head;
        Node current2 = num2.head;
        int carry = 0;

        while (current1 != null || current2 != null) {
            int value1 = (current1 != null) ? current1.value : 0;
            int value2 = (current2 != null) ? current2.value : 0;
            int sum = value1 + value2 + carry;
            carry = sum / 10;
            result.add(sum % 10);

            if (current1 != null) current1 = current1.next;
            if (current2 != null) current2 = current2.next;
        }

        if (carry > 0) {
            result.add(carry);
        }

        return result;
    }

    public static LinkedList multiply(LinkedList num1, LinkedList num2) {
        if (num1.head == null || num2.head == null) {
            return new LinkedList(new Node(0, null));
        }

        LinkedList result = new LinkedList(new Node(0, null));
        LinkedList tempResult = new LinkedList(new Node(0, null));
        Node current2 = num2.head;
        int shift = 0;

        while (current2 != null) {
            int digit2 = current2.value;
            tempResult = multiplyByDigit(num1, digit2);
            for (int i = 0; i < shift; i++) {
                tempResult.add(0);
            }
            result = add(result, tempResult);
            shift++;
            current2 = current2.next;
        }

        return result;
    }

    public static LinkedList multiplyByDigit(LinkedList num, int digit) {
        LinkedList result = new LinkedList(null);
        Node current = num.head;
        int carry = 0;

        while (current != null) {
            int value = current.value;
            int product = value * digit + carry;
            carry = product / 10;
            result.add(product % 10);
            current = current.next;
        }

        if (carry > 0) {
            result.add(carry);
        }

        return result;
    }

    public static LinkedList exponentiate(LinkedList num1, LinkedList num2) {
        if (num2.head == null) {
            // Anything raised to the power of 0 is 1
            return new LinkedList(new Node(1, null));
        }

        int exponent = num2ToInt(num2);

        LinkedList result = new LinkedList(new Node(1, null));
        LinkedList base = new LinkedList(num1.head);

        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = multiply(result, base);
            }
            base = multiply(base, base);
            exponent /= 2;
        }

        return result;
    }

    public static int num2ToInt(LinkedList num2) {
        int result = 0;
        Node current = num2.head;

        while (current != null) {
            result = (result * 10) + current.value;
            current = current.next;
        }

        return result;
    }
}
