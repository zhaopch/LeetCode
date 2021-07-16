package com.zhaopch.algorithm;

/**
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * @author PengCheng.Zhao
 */
public class LeetCode002 {
//	public static void main(String[] args) {
//		ListNode l1, l2, temp;
//		l1 = new ListNode(5);
//		temp = l1;
//		temp.next = new ListNode(2);
//		temp = temp.next;
//		temp.next = new ListNode(0);
//		temp = temp.next;
//		temp.next = new ListNode(3);
//		temp = temp.next;
////		l1.next = new ListNode(2);
////		l1.next.next = new ListNode(0);
////		l1.next.next.next = new ListNode(3);
//		l2 = new ListNode(8);
//		l2.next = new ListNode(3);
//		l2.next.next = new ListNode(1);
//		l2.next.next.next = new ListNode(7);
//		ListNode l3 = addTwoNumbers(l1, l2);
//		System.out.println("L1: " + l1.toString());
//		System.out.println("L2: " + l2.toString());
//		System.out.println("temp: " + temp.toString());
//		System.out.println("L3: " + l3.toString());
//	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			String result = "";
			if (next == null) {
				result += val;
			} else {
				result += val + "->" + next.toString();
			}
			return result;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		// TODO dummyHead赋值给curr，如何通过更改curr的值来更改dummyHead的值
		ListNode p = l1, q = l2, curr = dummyHead;
		int carry = 0;
		while (p != null || q != null) {
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			System.out.println("curr:" + curr.toString());
			System.out.println("dummyHead:" + dummyHead.toString());
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			if (p != null) {
				p = p.next;
			}
			if (q != null) {
				q = q.next;
			}
			System.out.println("curr:" + curr.toString());
			System.out.println("dummyHead:" + dummyHead.toString());
		}
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		return dummyHead.next;

	}
}
