package com.zhaopch.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author PengCheng.Zhao
 * 
 *         给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 *         ？找出所有满足条件且不重复的三元组。 注意：答案中不可以包含重复的三元组。
 */

public class LeetCode015 {
	public static void main(String[] args) {
		int[] nums = { -1, 2, -15, 6, 9, 11, 10, -7, 1 };
		List<List<Integer>> res = threeSum(nums);

		System.out.println(Arrays.toString(res.toArray()));
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < 3) {
			return res;
		}
		int length = nums.length;
		Arrays.sort(nums);// TODO sort规则
		for (int i = 0; i < length; i++) {
			// 当前数字大于0，则三数之和一定大于0；
			// 所以所以结束循环
			if (nums[i] >= 0) {
				break;
			}
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			} // 去重
			int left = i + 1;
			int right = length - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum == 0) {
					res.add(Arrays.asList(nums[i], nums[left], nums[right]));
					while (left < right && nums[left] == nums[left + 1])
						left++; // 去重
					while (left < right && nums[right] == nums[right - 1])
						right--; // 去重
					left++;
					right--;
				} else if (sum < 0) {
					left++;
				} else if (sum > 0) {
					right--;
				}
			}
		}
		return res;

	}
}
