package tasks.easy;

import tasks.utils.ListNode;

import java.util.ArrayList;

public class MergeTwoSortedList {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(2);
        ListNode list2 = new ListNode(1);
        ListNode merged = merge(list1, list2);
        System.out.println(merged);
    }

    private static ListNode merge(ListNode list1, ListNode list2) {
        ArrayList<ListNode> list = new ArrayList<>();
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    list.add(new ListNode(list1.val));
                    list1 = list1.next;
                } else {
                    list.add(new ListNode(list2.val));
                    list2 = list2.next;
                }
            } else if (list1 != null) {
                list.add(new ListNode(list1.val));
                list1 = list1.next;
            } else {
                list.add(new ListNode(list2.val));
                list2 = list2.next;
            }
        }
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }
        return list.isEmpty()
                ? list1
                : list.getFirst();
    }

    private static ListNode merge2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode tempNode;
        ListNode tempNode2;
        boolean firstLess = list1.val <= list2.val;
        if (firstLess) {
            tempNode = list1;
            tempNode2 = list2;
        } else {
            tempNode = list2;
            tempNode2 = list1;
        }
        ListNode prevNode = null;
        while (tempNode != null || tempNode2 != null) {
            if (tempNode != null && tempNode2 != null && tempNode.val <= tempNode2.val) {
                prevNode = tempNode;
                tempNode = tempNode.next;
            } else if (tempNode2 != null) {
                ListNode newListNode = new ListNode(tempNode2.val);
                newListNode.next = tempNode;
                prevNode.next = newListNode;
                tempNode2 = tempNode2.next;
            }
        }
        return firstLess
                ? list1
                : list2;
    }

}
