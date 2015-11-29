package com.neway.sort.linearlist;

/**
 * Created by Neway on 2015/11/29.
 */
public class Stack {

    /***
     * ��ת���ջ
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
     * �õ�ջ�׵�Ԫ��
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
