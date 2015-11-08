package com.neway.sort.tree;

import com.neway.sort.model.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * Created by Neway on 2015/11/1.
 */
public class TreeTraversal {

    public static void main(String args[]) {
        TreeNode a = new TreeNode(0);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(5);
        TreeNode g = new TreeNode(6);


        a.left = b;
        a.right = c;

        b.left = e;
        b.right = d;
        d.left = f;
        c.right = g;

        postTraversal(a);
        System.out.println();
        postTraversalByStack(a);
    }

    public static void preTraversalByStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if(root != null) {
            stack.push(root);
        }

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if( node != null) {
                System.out.print(node.val + " ");
            }

            if(node.right != null) {
                stack.push(node.right);
            }

            if(node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public static void preTraversal(TreeNode root) {
        if(root != null) {
            System.out.print(root.val + " ");
            preTraversal(root.left);
            preTraversal(root.right);
        } else {
            return;
        }
    }

    public static void inTraversal(TreeNode root) {
        if(root != null) {
            inTraversal(root.left);
            System.out.print(root.val + " ");
            inTraversal(root.right);
        } else {
            return;
        }
    }

    public static void inTraversalByStack(TreeNode root) {

        Stack<TreeNode> treeNodes = new Stack<>();
        while(root != null || !treeNodes.isEmpty()) {
            while(root != null) {
                treeNodes.push(root);
                root = root.left;
            }

            root = treeNodes.pop();
            System.out.print(root.val + " ");

            root = root.right;
        }
    }


    public static void postTraversal(TreeNode root) {
        if(root == null) {
            return;
        } else {
            postTraversal(root.left);
            postTraversal(root.right);
            System.out.print(root.val + " ");
        }
    }


    public static void postTraversalByStack(TreeNode root) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);

        while(!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if(node.left != null) {
                stack1.push(node.left);
            }

            if(node.right != null) {
                stack1.push(node.right);
            }
        }

        while(!stack2.isEmpty()) {
            TreeNode node = stack2.pop();
            System.out.print(node.val + " ");
        }

    }
}
