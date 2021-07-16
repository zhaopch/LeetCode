package com.zhaopch.algorithm;

import java.util.Stack;

/**
 * @author zhaopch
 * @date 2021/07/16
 * @description 调试入口
 */
public class AlgorithmMain {
    public static void main(String[] args) {
        //仅用递归和栈操作逆序一个栈---start
        Stack<Integer> test=new Stack<>();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        test.push(6);
        System.out.println(test);
        ReverseStackUsingRecursive.reverse(test);
        System.out.println(test);
        //仅用递归和栈操作逆序一个栈---end

    }
}
