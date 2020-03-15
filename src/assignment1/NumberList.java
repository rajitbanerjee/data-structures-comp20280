package assignment1;

import lists.DoublyLinkedList;

public class NumberList extends DoublyLinkedList<Integer> {

    public NumberList() {
    }

    public NumberList(int number) {
        while (number != 0) {
            addFirst(number % 10);
            number /= 10;
        }
    }

    public static NumberList add(NumberList num1, NumberList num2) {
        NumberList answer = new NumberList();
        int carry = 0;
        while (!num1.isEmpty() || !num2.isEmpty()) {
            int digit1 = 0, digit2 = 0;
            if (!num1.isEmpty()) {
                digit1 = num1.removeLast();
            }
            if (!num2.isEmpty()) {
                digit2 = num2.removeLast();
            }
            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            answer.addFirst(sum % 10);
        }
        if (carry != 0) {
            answer.addFirst(carry);
        }
        return answer;
    }

}
