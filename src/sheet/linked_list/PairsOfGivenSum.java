package sheet.linked_list;

import static sheet.linked_list.NodeDoubly.*;

public class PairsOfGivenSum {
    // use two pointer approach
    // given DLL is sorted
    public static void findPairs(NodeDoubly head, int x) {
        NodeDoubly first = head, second = head;
        while(second.next != null) {
            second = second.next;
        }
        //first -> first node and second -> last node of DLL
        while(first != second && second.next != first) {
            if(first.data + second.data == x) {
                System.out.println("(" + first.data + ", " + second.data + ")");
                first = first.next;
                second = second.prev;
            } else if(first.data + second.data < x) {
                first = first.next;
            } else {
                second = second.prev;
            }
        }
    }

    public static void main(String[] args) {
        NodeDoubly head;
        head = insert(null, 9);
        head = insert(head, 8);
        head = insert(head, 6);
        head = insert(head, 5);
        head = insert(head, 4);
        head = insert(head, 2);
        head = insert(head, 1);

        printDLL(head);
        findPairs(head, 7);
    }
}
