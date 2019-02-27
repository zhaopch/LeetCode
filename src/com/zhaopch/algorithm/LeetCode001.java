package com.zhaopch.algorithm;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author ZhaoPch
 * 
 *         两数之和 : 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的 两个 整数。
 *         你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 */
public class LeetCode001 {
	public static void main(String[] args) {
		int target = 11;
		int[] nums = { 0, 1, 2, 5, 6, 9, 11 };

		int[] result = twoSum2(nums, target);
		System.out.println(Arrays.toString(result));
	}

	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
		int[] res = new int[2];
		for (int i = 0; i < nums.length; ++i) {
			m.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; ++i) {
			int t = target - nums[i];
			if (m.containsKey(t) && m.get(t) != i) {
				res[0] = i;
				res[1] = m.get(t);
				break;
			}
		}
		return res;
	}

	public static int[] twoSum2(int[] nums, int target) {
		HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
		int[] res = new int[2];
		for (int i = 0; i < nums.length; ++i) {
			if (m.containsKey(target - nums[i])) {
				res[0] = i;
				res[1] = m.get(target - nums[i]);
				break;
			}
			m.put(nums[i], i);
		}
		return res;
	}
}
