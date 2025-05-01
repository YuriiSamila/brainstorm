package tasks.easy;

import tasks.utils.ListNode;

public class MergeTwoSortedList {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(2);
        ListNode list2 = new ListNode(1);
        ListNode merged = merge(list1, list2);
        System.out.println(merged);
    }

    private static ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
    ListNode tempNode = list1;
    ListNode prevNode = null;
    while (tempNode != null || list2 != null) {
        if (tempNode != null && list2 != null && tempNode.val <= list2.val) {
            prevNode = tempNode;
            tempNode = tempNode.next;
        } else if (list2 != null){
            ListNode newListNode = new ListNode(list2.val);
            newListNode.next = tempNode;
            prevNode.next = newListNode;
            list2 = list2.next;
        }
    }
    return list1;
    }

}
