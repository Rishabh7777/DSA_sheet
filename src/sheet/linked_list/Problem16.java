package sheet.linked_list;

public class Problem16 {
    public static boolean isCircular(Node head) {
        Node curr = head;
        while(true) {
            if(curr.next == head) {
                return true;
            }
            if(curr.next == null) {
                return false;
            }
            curr = curr.next;
        }
    }
}
