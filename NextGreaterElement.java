package com.practice.amit;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 *https://www.geeksforgeeks.org/next-greater-element/
 * Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an element x is
 * the first greater element on the right side of x in the array. Elements for which no greater element exist,
 * consider the next greater element as -1.
 *
 */
public class NextGreaterElement {

    public static void printNGE(int [] arr, int n) {
        int [] res = new int[arr.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < arr.length; ++i) {
            int num = arr[i];
            while(stack.size() >0 && arr[stack.peekLast()] < num) {
                int index = stack.pollLast();
                res[index] = num;
            }
            stack.offerLast(i);
        }
        while(!stack.isEmpty()) {
            res[stack.pollLast()] = -1;
        }

        for(Integer num : res) {
            System.out.println(num);
        }
    }
    public static void main(String [] args) {
        int arr[] = { 11, 13, 21, 3, 4,5,6,7,12,10,9,13 };
        int n = arr.length;
        printNGE(arr, n);
    }
}
