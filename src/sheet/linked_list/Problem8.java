package sheet.linked_list;

//move last node of LL to first position, i.e. rotate LL clockwise by 1
public class Problem8 {
    public static Node rotate(Node head) {
        Node curr = head;
        while(curr.next.next != null) {
            curr = curr.next;
        }
        curr.next.next = head;
        head = curr.next;
        curr.next = null;
        return head;
    }
}
