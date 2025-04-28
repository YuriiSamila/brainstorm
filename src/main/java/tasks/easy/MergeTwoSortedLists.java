package tasks.easy;

public class MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode next = new ListNode();
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        if (temp1.val < temp2.val) {
            result.val = temp1.val;
            temp1 = temp1.next;
        } else {
            result.val = temp2.val;
            temp2 = temp2.next;
        }

        while (true) {
            if (temp1.val < temp2.val) {
                result.next = new ListNode(temp1.val);
                temp1 = temp1.next;
            } else {
                result.val = temp2.val;
                result.next = next;
                temp2 = temp2.next;
            }
        }

    }

    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                list1.next = mergeTwoLists2(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists2(list1, list2.next);
                return list2;
            }
        }
        if (list1 == null)
            return list2;
        return list1;
    }

    public static void main(String[] args) {
        System.out.println(mergeTwoLists2(new ListNode(1, new ListNode(2, new ListNode(4))),
                new ListNode(1, new ListNode(3, new ListNode(4)))));
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
