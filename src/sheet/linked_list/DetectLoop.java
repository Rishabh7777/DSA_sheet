package sheet.linked_list;

//detect loop in the linked list
public class DetectLoop {
    //use two pointers
    public static boolean isLoopPresent(Node head) {
        if(head == null) {
            return false;
        }
        Node slow = head, fast = head.next;
        while(slow != fast) {
            if(fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
