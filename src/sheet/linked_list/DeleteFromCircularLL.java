package sheet.linked_list;

public class DeleteFromCircularLL {
    public static Node deleteNode(Node head, int key) {
        //if LL is empty
        if(head == null) {
            return null;
        }
        //if LL has only one node
        if(head.next == head) {
            if(head.data == key) {
                return null;
            } else {
                System.out.println("No such node present.");
                return head;
            }
        }
        //if LL has more than one node
        Node prev = head, curr = head.next;
        while(curr.data != key) {
            prev = curr;
            curr = curr.next;
            if(curr == head.next) {
                System.out.println("No such node present.");
                return prev;
            }
        }
        //curr -> node to be deleted
        if(head == curr) {
            head = head.next;
        }
        prev.next = curr.next;
        curr.next = null;
        return head;
    }
}
