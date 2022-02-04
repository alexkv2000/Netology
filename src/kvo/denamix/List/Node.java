package kvo.denamix.List;

public class Node {
    int value;
    Node prev;

    public Node(int value) {
        this.value = value;
        this.prev = null;
    }

    public int getValue() {
        return value;
    }

    public Node getPrev() {
        if ((prev) == (null)) {
            return null;
        } else {
            return this.prev;
        }
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
