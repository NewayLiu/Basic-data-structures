package com.neway.sort.linearlist;

/**
 * Created by Neway on 2015/11/29.
 */
public class Stack {

    /***
     * 反转这个栈
     * @param stack
     */
    public void reverseStack(java.util.Stack<Integer> stack) {
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
    public int getBottom(java.util.Stack<Integer> stack) {

        int last = stack.pop();
        if(stack.isEmpty()) {
            return last;
        }

        int bottom = getBottom(stack);
        stack.push(last);

        return bottom;
    }
}
