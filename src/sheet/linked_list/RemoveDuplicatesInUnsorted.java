package sheet.linked_list;

import java.util.HashSet;
import java.util.Set;

//remove duplicates from an unsorted list
public class RemoveDuplicatesInUnsorted {
    public static void removeDuplicates(Node head) {
        Set<Integer> set = new HashSet<>();
        Node curr = head;
        set.add(curr.data);
        while(curr.next != null) {
            if(set.contains(curr.next.data)) {
                Node temp = curr.next;
                curr.next = curr.next.next;
                temp.next = null;
                continue;
            }
            set.add(curr.next.data);
            curr = curr.next;
        }
    } //O(n), using O(n) extra space
}
