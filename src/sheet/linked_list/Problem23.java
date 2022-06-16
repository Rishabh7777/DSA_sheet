package sheet.linked_list;

import java.util.Comparator;
import java.util.PriorityQueue;

import static sheet.linked_list.NodeDoubly.*;

//sort a nearly (or k-sorted) DLL
//either insertion sort or heap sort can be used for this
public class Problem23 {
    static class CompareNodes implements Comparator<NodeDoubly> {
        public int compare(NodeDoubly n1, NodeDoubly n2) {
            return n1.data - n2.data;
        }
    }

    public static NodeDoubly sortKSortedDLL(NodeDoubly head, int k) {
        if(head == null || head.next == null) {
            return head;
        }
        //create a min-heap from first (k+1) nodes
        PriorityQueue<NodeDoubly> pq = new PriorityQueue<>(new CompareNodes());
        while(k >= 0) {
            pq.add(head);
            head = head.next;
            k--;
        }
        //now poll min node from pq and make necessary updates to pointers
        //and after each poll, add a new node from DLL to pq
        NodeDoubly newHead = null, last = head;
        while(!pq.isEmpty()) {
            if(newHead == null) {
                newHead = pq.peek();
                newHead.prev = null;
                last = newHead;
            } else {
                NodeDoubly curr = pq.peek();
                curr.prev = last;
                last.next = curr;
                last = curr;
            }
            pq.poll();
            //add one node from DLL
            if(head != null) {
                pq.add(head);
                head = head.next;
            }
        }
        last.next = null;
        return newHead;
    } //O(n * log(k))

    public static void main(String[] args) {
        NodeDoubly head;
        head = insert(null, 8);
        head = insert(head, 56);
        head = insert(head, 12);
        head = insert(head, 2);
        head = insert(head, 6);
        head = insert(head, 3);

        printDLL(head);
        head = sortKSortedDLL(head, 2);
        printDLL(head);
    }
}
