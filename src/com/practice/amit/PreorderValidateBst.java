package com.practice.amit;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://www.geeksforgeeks.org/check-if-a-given-array-can-represent-preorder-traversal-of-binary-search-tree/#
 *
 */
public class PreorderValidateBst {
    public static boolean canRepresentBST(int [] pre ) {
        Deque<Integer> stack = new ArrayDeque<>();
        int root = Integer.MIN_VALUE;
        for(int i =0 ; i< pre.length; ++i) {
            int num = pre[i];
            if(pre[i] < root) return false;
            while(stack.size() >0 && stack.getLast()  < pre[i]) {
                root = stack.pollLast();
            }
            stack.addLast(pre[i]);
        }
        return true;
    }

    public static void main(String [] args) {

        int[] pre1 = new int[]{40, 30,20,10,15, 35, 80, 100};
        int n = pre1.length;
        if (canRepresentBST(pre1) == true) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        int[] pre2 = new int[]{40, 30, 35,20, 80, 100};
        int n1 = pre2.length;
        if (canRepresentBST(pre2) == true) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
