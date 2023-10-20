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
        if (num1.head == null || num2.head == null || num1.head.value == 0 || num2.head.value == 0) {
            return new LinkedList(new Node(0, null));
        }

        LinkedList result = new LinkedList(new Node(0, null));

        Node current1 = num1.head;

        while (current1 != null) {
            int digit1 = current1.value;
            LinkedList tempResult = multiplyByDigit(num2, digit1);
            for (int i = 0; i < num1.getLength() - (current1 == num1.head ? 1 : 0); i++) {
                tempResult.add(0);
            }
            result = add(result, tempResult);
            current1 = current1.next;
        }

        return result;
    }

    public static LinkedList multiplyByDigit(LinkedList num, int digit) {
        LinkedList result = new LinkedList(null);
        int carry = 0;

        Node current = num.head;

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

        for (int i = 0; i < exponent; i++) {
            result = multiply(result, num1);
        }

        return result;
    }

    public static int num2ToInt(LinkedList num2) {
        int result = 0;
        int powerOf10 = 1;
        Node current = num2.head;

        while (current != null) {
            result = result + (current.value * powerOf10);
            powerOf10 *= 10;
            current = current.next;
        }

        return result;
    }
}
