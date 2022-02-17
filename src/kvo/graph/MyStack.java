package kvo.graph;

public class MyStack<Integer> {
    private int index; // индекс элементов стека
    private int[] array; // массив вершин обхода

    public MyStack(int size) {
        array = new int[size];
        index = -1;
    }

    public void push(int v) {
        array[++index] = v;
    }

    public int pop() {
        return array[index--];
    }

    public int peek() {
        return array[index];
    }

    public boolean isEmpty() {
        if (index == -1) {
            return true;
        } else {
            return false;
        }
    }
}
