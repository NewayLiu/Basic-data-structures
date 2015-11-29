package com.neway.sort.linearlist;

import java.util.Stack;

/**
 * Created by Neway on 2015/11/29.
 */
public class StackOperation {

    /***
     * reverse the stack by Recursive
     *
     * @param stack
     */
    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int bottom = getBottom(stack);
        reverseStack(stack);
        stack.push(bottom);
    }

    /**
     * Get the bottom element in the stack by Recursive
     *
     * @param stack
     * @return
     */
    public static int getBottom(Stack<Integer> stack) {

        int last = stack.pop();
        if (stack.isEmpty()) {
            return last;
        }

        int bottom = getBottom(stack);
        stack.push(last);

        return bottom;
    }


    /**
     * Sort the stock,Just like Tower of Hanoi
     * The method only apply for one stack.
     * @param stack
     */
    public static void sortTheStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        Stack<Integer> help = new Stack<>();
        int currentTop = stack.pop();
        int maxInHelp = currentTop;
        help.push(currentTop);

        while (!stack.isEmpty()) {
            currentTop = stack.pop();
            int currentSize = stack.size();
            if (currentTop < maxInHelp) {
                /**
                 * find where we should push the currentTop
                 */
                while (currentTop > help.peek()) {
                    stack.push(help.pop());
                }
            } else {
                /**
                 * the current should be put in the bottom of the stack.
                 */
                while (!help.isEmpty()) {
                    stack.push(help.pop());
                }
                maxInHelp = currentTop;
            }
            help.push(currentTop);
            for (; stack.size() > currentSize; ) {
                help.push(stack.pop());
            }
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }
}
