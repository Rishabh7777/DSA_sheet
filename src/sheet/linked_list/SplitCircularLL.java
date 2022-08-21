package sheet.linked_list;

public class SplitCircularLL {
    public static Node[] splitList(Node head) {
        if(head.next == null) {
            return new Node[]{head, head};
        }
        int count = 1;
        Node curr = head;
        // count the total number of nodes in LL
        while(curr.next != head) {
            count++;
            curr = curr.next;
        }
        Node head2;
        curr = head;
        int i = 0;
        while(true) {
            if(count%2 == 0 && i == count/2 - 1) {
                Node temp = curr.next;
                curr.next = head;
                curr = temp;
                head2 = curr;
                break;
            }
            if(count%2 != 0 && i == count/2) {
                Node temp = curr.next;
                curr.next = head;
                curr = temp;
                head2 = curr;
                break;
            }
            i++;
            curr = curr.next;
        }
        while(curr.next != head) {
            curr = curr.next;
        }
        curr.next = head2;
        return new Node[]{head, head2};
    }

    public static void printCircularLL(Node head) {
        if(head == null) {
            System.out.println("null");
            return;
        }
        Node curr = head;
        while(curr.next != head) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println(curr.data + " -> " + head.data);
    }
}
