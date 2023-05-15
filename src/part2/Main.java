package part2;

import part2.Stack;

public class Main1 {
    public static void main(String[] args) {
        //Part2 Stack
        System.out.println("Part2 Stack");
        Stack<Integer> stack = new Stack<>();
        //push elements to the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        System.out.println("stack after pushing elements: " + stack);
        System.out.println("------------------");
        Integer item1 = stack.pop();
        Integer item2 = stack.pop();
        System.out.println(item1 + " and " + item2 + " was popped");
        System.out.println("stack after popping two elements: " + stack);

    }
}
