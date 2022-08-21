package sheet.linked_list;

import static sheet.linked_list.NodeDoubly.insert;

public class CountTripletsOfGivenSum {
    //use two pointer approach
    private static int findPairs(NodeDoubly head, int x) {
        NodeDoubly first = head, second = head;
        while(second.next != null) {
            second = second.next;
        }
        int count = 0;
        //first -> first node and second -> last node of DLL
        while(first != second && second.next != first) {
            if(first.data + second.data == x) {
                count++;
                first = first.next;
                second = second.prev;
            } else if(first.data + second.data < x) {
                first = first.next;
            } else {
                second = second.prev;
            }
        }
        return count;
    }

    //fix one node for triplet, then use two pointer to find two other nodes
    public static int countTriplets(NodeDoubly head, int sum) {
        if(head == null || head.next == null) {
            return 0;
        }
        int triplets = 0;
        while(head.next.next != null) {
            triplets += findPairs(head.next, sum - head.data);
            head = head.next;
        }
        return triplets;
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

        System.out.println(countTriplets(head, 1));
    }
}
