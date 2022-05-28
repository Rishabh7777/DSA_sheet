package sheet.linked_list;

import java.util.HashSet;
import java.util.Set;

//remove duplicates from an unsorted list
public class Problem7 {
    public static void removeDuplicates(Node head) {
        Set<Integer> set = new HashSet<>();
        Node curr = head;
        set.add(curr.getData());
        while(curr.getNext() != null) {
            if(set.contains(curr.getNext().getData())) {
                Node temp = curr.getNext();
                curr.setNext(curr.getNext().getNext());
                temp.setNext(null);
                continue;
            }
            set.add(curr.getNext().getData());
            curr = curr.getNext();
        }
    } //O(n), using O(n) extra space

    public static void main(String[] args) {
        Node head = new Node(4);
        Node node2 = new Node(2);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        head.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        Problem1.printLL(head);
        removeDuplicates(head);
        Problem1.printLL(head);
    }
}
