package sheet.linked_list;

import static sheet.linked_list.Problem1.printLL;

public class Problem14 {
    private static Node partition(Node head, Node tail) {
        int pivot = tail.data;
        Node curr = head, pivotPrev = head;
        while(head != tail) {
            if(head.data < pivot) {
                pivotPrev = curr;
                //swap data between curr and head
                int temp = curr.data;
                curr.data = head.data;
                head.data = temp;
                curr = curr.next;
            }
            head = head.next;
        }
        //place pivot at its right position
        int temp = curr.data;
        curr.data = pivot;
        tail.data = temp;
        return pivotPrev;
    }

    public static void sort(Node head, Node tail) {
        if(head == null || head == tail || head == tail.next) {
            return;
        }
        //get previous of pivot (last node in LL) node
        Node pivotPrev = partition(head, tail);
        //recursive call for left sub-part
        sort(head, pivotPrev);
        //recursive call for right sub-part, which has two cases
        if(pivotPrev != null && pivotPrev == head) {
            //if pivot is found and places as head of LL
            sort(pivotPrev.next, tail);
        } else if(pivotPrev != null && pivotPrev.next != null) {
            //if pivot is placed somewhere in between
            sort(pivotPrev.next.next, tail);
        }
    }
}
