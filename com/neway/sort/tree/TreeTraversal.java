package com.neway.sort.tree;

import com.neway.sort.model.TreeNode;

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

        postTraversalByStack(a);
        System.out.println();
        postTraversal(a);
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

    public static void postTraversal(TreeNode root) {
        if(root != null) {
            postTraversal(root.left);
            System.out.print(root.val + " ");
            postTraversal(root.right);
        } else {
            return;
        }
    }

    public static void postTraversalByStack(TreeNode root) {


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


}
