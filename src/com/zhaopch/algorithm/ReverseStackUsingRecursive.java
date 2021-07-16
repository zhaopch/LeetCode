package com.zhaopch.algorithm;

import java.util.Stack;

public class ReverseStackUsingRecursive {

    public static void main(String[] args) {
        Stack<Integer> test = new Stack<>();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        System.out.println(test);
        ReverseStackUsingRecursive.reverse(test);
        System.out.println(test);
    }
    private int getAndRemoveLastElement(Stack<Integer> stack){
        int result = stack.pop();
        if (stack.isEmpty()){
            return result;
        } else {
            int lastElement = getAndRemoveLastElement(stack);
            stack.push(result);
            return lastElement;
        }
    }
    public static void reverse(Stack<Integer> stack){
        if (stack.isEmpty()) {
            return;
        }
        int i = new ReverseStackUsingRecursive().getAndRemoveLastElement(stack);
        System.out.println(i);
        reverse(stack);
        stack.push(i);
    }
}
