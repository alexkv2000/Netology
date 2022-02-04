package kvo.denamix.List;

public class Stack {
    Node head;

    public Stack() {
    }

    Node reversed_head(Node head) {
        if (head == null) {
            return null;
        }
        if (head.getPrev() == (null)) { // если остался последний элемент - ОН ГОЛОВА
            return head;
        }

        Node newHead = reversed_head(head.prev);
        head.getPrev().setPrev(head);
        head.setPrev(null);

        return newHead;
    }

    void reverse() {
        this.head = reversed_head(this.head);
    }

    void printme() {
        if (this.head == (null)) {
            System.out.print("EMPTY");
        } else {
            Node node = this.head;
            while (node != (null)) {
                System.out.print(node.value);
                if (node.prev != null) {
                    System.out.print(" -> ");
                }
                node = node.getPrev();
            }
        }
        System.out.println();
    }

    void push(int value) {
        if (this.head == (null)) {
            this.head = new Node(value);
        } else {
            Node node = new Node(value);
            node.prev = this.head;
            this.head = node;
        }
    }

    int pop() {
        if (this.head == (null)) {
            return -1;
        } else {
            int value = head.getValue();
            head = head.getPrev();
            return value;
        }
    }
}
