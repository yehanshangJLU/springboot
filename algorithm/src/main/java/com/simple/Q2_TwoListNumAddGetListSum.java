package com.simple;

import com.alibaba.fastjson.JSONObject;
import com.dto.ListNode;

/**
 * leetCode  question 2. 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * <p>
 * 提示：
 * <p>
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 */
public class Q2_TwoListNumAddGetListSum {

    public static void main(String[] args) {

       /* ListNode l1 = new ListNode(2,new ListNode(4,new ListNode(3,null)));
        ListNode l2 = new ListNode(5,new ListNode(6,new ListNode(4,null)));*/
/*        ListNode l1 = new ListNode(0,null);
        ListNode l2 = new ListNode(0,null);*/
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null))));
        Q2_TwoListNumAddGetListSum Q2_TwoListNumAddGetListSum = new Q2_TwoListNumAddGetListSum();

        // ListNode result =Q2_TwoListNumAddGetListSum.addTwoNumbers(l1,l2);
        ListNode result = Q2_TwoListNumAddGetListSum.addTwoNumberRsecursion(l1, l2);
        System.out.println(result);

    }

    //solution 1： 循环解法

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        long start = System.nanoTime();
        if (l1 == null || l2 == null) {
            return null;
        }
        //结果集
        ListNode result = null;

        ListNode oneNode = l1;
        ListNode TwoTwo = l2;
        ListNode currteNode = null;
        int carryDigit = 0; //进位数
        for (; ; ) {

            if (oneNode == null && TwoTwo == null) {
                if (carryDigit == 1) {
                    currteNode.next = new ListNode(carryDigit, null);
                }
                break;

            }
            int one = 0;
            ListNode oneNext = null;
            if (oneNode != null) {
                one = oneNode.val;
                oneNext = oneNode.next;
            }

            int two = 0;

            ListNode twoNext = null;
            if (TwoTwo != null) {
                two = TwoTwo.val;
                twoNext = TwoTwo.next;
            }

            int sum = one + two + carryDigit;

            int Difference = sum - 10;

            if (Difference >= 0) {
                carryDigit = 1;
            } else {
                carryDigit = 0;
                Difference = sum;
            }

            if (currteNode == null) {
                currteNode = new ListNode(Difference, null);
            } else {
                currteNode.next = new ListNode(Difference, null);
                currteNode = currteNode.next;
            }

            if (result == null) {
                result = currteNode;
            }
            oneNode = oneNext;
            TwoTwo = twoNext;


        }

        long end = System.nanoTime();

        System.out.println("时间纳秒：" + (end - start));
        return result;
    }

    // solution 2：递归解法
    public ListNode addTwoNumberRsecursion(ListNode l1, ListNode l2) {

        long start = System.nanoTime();
        if (l1 == null || l2 == null) {
            return null;
        }
        //结果集
        ListNode result = rsecursion(l1, l2, 0);


        long end = System.nanoTime();

        System.out.println("时间纳秒：" + (end - start));
        return result;
    }

    ListNode rsecursion(ListNode oneNode, ListNode TwoNode, int carryDigit) {
        ListNode currteNode = null;

        if (oneNode == null && TwoNode == null) {
            if (carryDigit == 1) {
                currteNode = new ListNode(carryDigit, null);
            }
            return currteNode;
        }

        int one = 0;
        ListNode oneNext = null;
        if (oneNode != null) {
            one = oneNode.val;
            oneNext = oneNode.next;
        }
        int two = 0;
        ListNode twoNext = null;
        if (TwoNode != null) {
            two = TwoNode.val;
            twoNext = TwoNode.next;
        }

        //计算当前的和
        int sum = one + two + carryDigit;

        int difference = sum - 10;
        if (difference >= 0) {//大于10，，进位数为1  difference 为个位数
            carryDigit = 1;
        } else {
            carryDigit = 0;
            difference = sum;
        }

        currteNode = new ListNode(difference, rsecursion(oneNext, twoNext, carryDigit));
        return currteNode;
    }


    // solution 3：优秀的代码
    public ListNode addTwoNumberExcellence(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        int carry = 0, newVal = 0;
        while (p1 != null || p2 != null || carry > 0) {
            newVal = (p1 == null ? 0: p1.val) + (p2 == null ? 0: p2.val) + carry;
            carry = newVal / 10;
            newVal %= 10;
            p.next = new ListNode(newVal);
            p1 = p1 == null? null: p1.next;
            p2 = p2 == null? null: p2.next;
            p = p.next;
        }
        return dummy.next;
    }



}
