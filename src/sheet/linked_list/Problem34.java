package sheet.linked_list;

//segregate even and odd nodes in LL
public class Problem34 {
    public static Node divide(int N, Node head){
        Node curr = head, prev = head, lastEven = head;
        //move to the first odd node
        while(curr != null && curr.data % 2 == 0) {
            prev = curr;
            lastEven = prev;
            curr = curr.next;
        }
        while(curr != null) {
            if(curr.data % 2 != 0) {
                prev = curr;
                curr = curr.next;
            } else {
                //if curr node is first even node found
                if(lastEven.data % 2 != 0) {
                    prev.next = curr.next;
                    curr.next = head;
                    head = curr;
                    curr = prev.next;
                    lastEven = head;
                } else {
                    prev.next = curr.next;
                    curr.next = lastEven.next;
                    lastEven.next = curr;
                    lastEven = lastEven.next;
                    curr = prev.next;
                }
            }
        }
        return head;
    }
}
