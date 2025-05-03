package tasks.easy;

import tasks.utils.ListNode;

public class DuplicatesRemoval {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))))));
    }

    private static ListNode removeDuplicates(ListNode head) {
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.val != temp.next.val) {
                temp = temp.next;
            } else {
                temp.next = temp.next.next;
            }
        }
        return head;
    }




}
