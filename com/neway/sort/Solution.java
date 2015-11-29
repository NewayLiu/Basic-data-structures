package com.neway.sort;


import com.neway.sort.linearlist.StackOperation;

import java.util.Stack;

public class Solution {

    public static void main(String arg[]) {
        Solution s = new Solution();
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(5);
        stack.push(4);
        stack.push(2);
        stack.push(6);
        stack.push(-2);
        stack.push(-3);
        stack.push(9);
        stack.push(7);
        stack.push(1);

        StackOperation.sortTheStack(stack);
        System.out.println(0);

    }


    /***
     * 反转这个栈
     * @param stack
     */
    public void reverseStack(Stack<Integer> stack) {
        if(stack.isEmpty()) {
            return;
        }

        int bottom = getBottom(stack);
        reverseStack(stack);
        stack.push(bottom);
    }

    /**
     * 得到栈底的元素
     * @param stack
     * @return
     */
    public int getBottom(Stack<Integer> stack) {

        int last = stack.pop();
        if(stack.isEmpty()) {
            return last;
        }

        int bottom = getBottom(stack);
        stack.push(last);

        return bottom;
    }
}