package linkedlist;


import stack.Stack;

import java.util.Random;

public class Main {
    private static double testStack(Stack<Integer> stack, int opCount) {
        long startTime = System.nanoTime();
        Random random = new Random();

        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
//        int opCount = 1000000;
//        ArrayStack<Integer> arrayStack = new ArrayStack<>();
//        double time1 = testStack(arrayStack, opCount);
//        System.out.println("ArrayStack, time: " + time1 + " s");
//
//        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
//        double time2 = testStack(linkedListStack, opCount);
//        System.out.println("LinkedListStack, time: " + time2 + " s");
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(2);
        System.out.println(list);
        list.removeElement(2);
        System.out.println(list);


    }
}
