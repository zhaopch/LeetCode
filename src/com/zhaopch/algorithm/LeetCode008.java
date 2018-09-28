package com.zhaopch.algorithm;

/**
 *
 * 
 *         实现 atoi，将字符串转为整数
 * 
 *   atoi的要求：
 * 
 *         这个函数需要丢弃之前的空白字符，直到找到第一个非空白字符。之后从这个字符开始，选取一个可选的正号或负号后面跟随尽可能多的数字，并将其解释为数字的值。
 *         字符串可以在形成整数的字符后包括多余的字符，将这些字符忽略，这些字符对于函数的行为没有影响。
 *         如果字符串中的第一个非空白的字符不是有效的整数，或者没有这样的序列存在，字符串为空或者只包含空白字符则不进行转换。
 *         如果不能执行有效的转换，则返回 0。如果正确的值超过的可表示的范围，则返回 INT_MAX（2147483647）或
 *   INT_MIN（-2147483648）。
 * 
 * 	 @author ZhaoPch
 * 
 */
public class LeetCode008 {

	public static void main(String[] args) {
		String test = "-215945451515185dawd";
		System.out.println(atoi(test));
	}

	// Solution 1
	public static int myAtoi(String str) {
		// 合法性判断
		if (str.isEmpty()) {
			return 0;
		}

		// 正负号标记
		int sign = 1;

		// 转换值
		int base = 0;

		// 索引位数
		int i = 0;

		// 剔除开始空白字符
		while (str.charAt(i) == ' ') {
			i++;
		}

		// 判断正负号
		if (str.charAt(i) == '-' || str.charAt(i) == '+') {
			sign = str.charAt(i++) == '-' ? -1 : 1;
		}
		// 索引有效数字字符
		while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {

			// that statement is used to test if the num is bigger than INT_MAX after the
			// str[i] is handled, if base > INT_MAX/10,
			// then base10+ str[i] -‘0’> base10>INT_MAX, or when base== INT_MAX/10, that
			// means all the places are the same as INT_MAX except the ones place, so
			// str[i]>‘7’ is needed.
			// 上面这段是LeetCode国外站对下面代码的解释。
			// 简单来说就是00
			// 如果`base > MAX_VALUE/10`，那么`base*10 + new_value` > `base*10` >
			// `MAX_VALUE`。这个应该很容易理解，这种情况下就会发生溢出。
			// 若`base == INT_MAX/10`，而且`new_value = str.charAt(i++) -
			// '0'`大于`7`，也会发生溢出。因为`MAX_VALUE = 2147483647`
			if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
				return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}

			// 计算转换值
			base = 10 * base + (str.charAt(i++) - '0');
		}

		// 计算结果值
		return base * sign;
	}

	// Solution 2
	public static int atoi(String str) {
		// 去除小数位和两边的空格，存在str1中
		String str1 = null;
		// 后面数字和非数字混合的情况，用于截取前面的数字
		StringBuilder sb = new StringBuilder();
		if (str.contains(".")) {
			str1 = str.substring(0, str.indexOf(".")).trim();
		} else {
			str1 = str.trim();
		}
		try {
			if ("".equals(str1)) {
				return 0;
			}
			return Integer.parseInt(str1);
		} catch (NumberFormatException e) {
			/*
			 * 先进行判断，字符串前面是否有"+"和"-"，分三种情况
			 */
			// 1.前面既没有"+"也没有"-"
			if (str1.charAt(0) != '-' && str1.charAt(0) != '+') {
				processData(0, str1, sb);
				if (sb.length() == 0) {// 第一个是非数字
					return 0;
				} else if (sb.length() < str1.length()) {// 数字中夹杂非数字
					return atoi(sb.toString());
				} else {// 全是数字
					return Integer.MAX_VALUE;
				}
				// 2.前面是"+"
			} else if (str1.charAt(0) == '+') {
				processData(1, str1, sb);
				if (sb.length() == 0) {// 第一个是非数字
					return 0;
				} else if (sb.length() < str1.length() - 1) {// 数字中夹杂非数字
					return atoi(sb.toString());
				} else {// 全是数字
					return Integer.MAX_VALUE;
				}
				// 3.前面是"-"
			} else {
				sb.append('-');
				processData(1, str1, sb);
				if (sb.length() == 1) {// 第一个是非数字
					return 0;
				} else if (sb.length() < str1.length()) {// 数字中夹杂非数字
					return atoi(sb.toString());
				} else {// 全是数字
					return Integer.MIN_VALUE;
				}
			}
		}
	}

	public static void processData(int start, String str1, StringBuilder sb) {
		for (int i = start; i < str1.length(); i++) {
			if (str1.charAt(i) < '0' || str1.charAt(i) > '9') {
				break;
			}
			sb.append(str1.charAt(i));
		}
	}
}
