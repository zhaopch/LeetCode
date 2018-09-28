package com.zhaopch.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * 
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * 
 * 示例 1: 输入: "abcabcbb" 输出: 3 解释: 无重复字符的最长子串是 "abc"，其长度为 3。
 * 
 * 示例 2: 输入: "bbbbb" 输出: 1 解释: 无重复字符的最长子串是 "b"，其长度为 1。
 *
 * @author ZhaoPch
 * 
 */
public class LeetCode003 {
	public static void main(String[] args) {
		String t = "asdkanjklfhuiqwueojalknsdahsoidfmnlajhsiodfhalsxmdlakjsdkolajlksdmakljhsdlkmasaskjduoaijsldmldjakjsdlm";
		System.out.println(lengthOfLongestSubstring(t));
	}

	// Solution 1
	public static int lengthOfLongestSubstring(String s) {
		int n = s.length();
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j <= n; j++)
				if (allUnique(s, i, j)) {
					ans = Math.max(ans, j - i);
				}
		}
		return ans;
	}

	public static boolean allUnique(String s, int start, int end) {
		Set<Character> set = new HashSet<>();
		for (int i = start; i < end; i++) {
			Character ch = s.charAt(i);
			if (set.contains(ch)) {
				return false;
			}
			set.add(ch);
		}
		return true;
	}
	// Solution 2

	public static int lengthOfLongestSubstring2(String s) {
		int n = s.length(), ans = 0;
		Map<Character, Integer> map = new HashMap<>(); // current index of character
		// try to extend the range [i, j]
		for (int j = 0, i = 0; j < n; j++) {
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);
			}
			ans = Math.max(ans, j - i + 1);
			map.put(s.charAt(j), j + 1);
		}
		return ans;
	}
}
