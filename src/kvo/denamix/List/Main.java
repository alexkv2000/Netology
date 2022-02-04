package kvo.denamix.List;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.printme();
        addstack(stack, 0);
        addstack(stack, 1);
        addstack(stack, 2);
        addstack(stack, 3);
        addstack(stack, 4);
        addstack(stack, 5);
        System.out.println();
        popStack(stack);
        popStack(stack);
        reversStack(stack);

        popStack(stack);
        popStack(stack);

        reversStack(stack);

        popStack(stack);
        popStack(stack);
        popStack(stack);
        addstack(stack, 0);
        addstack(stack, 1);
    }

    private static void reversStack(Stack stack) {
        System.out.printf("%11s Ревёрс!     ", " ");
        stack.reverse();
        stack.printme();
    }

    private static void popStack(Stack stack) {
        int valueStack = stack.pop();
        System.out.print("снимем со стека (" + ANSI_GREEN + (valueStack == -1 ? "стек пустой" : valueStack) + ANSI_RESET + ") \t");
        stack.printme();
    }

    private static void addstack(Stack stack, int value) {
        System.out.printf("Добавим в стек : %-15s ", ANSI_GREEN + value + ANSI_RESET);
        stack.push(value);
        stack.printme();
    }

}
