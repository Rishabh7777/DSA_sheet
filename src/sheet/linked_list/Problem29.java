package sheet.linked_list;

public class Problem29 {
    public static Node segregate(Node head) {
        int one = 0, zero = 0, two = 0;
        Node curr = head;
        while(curr != null) {
            if(curr.data == 0) {
                zero++;
            } else if(curr.data == 1) {
                one++;
            } else {
                two++;
            }
            curr = curr.next;
        }
        curr = head;
        while(zero > 0) {
            curr.data = 0;
            curr = curr.next;
            zero--;
        }
        while(one > 0) {
            curr.data = 1;
            curr = curr.next;
            one--;
        }
        while(two > 0) {
            curr.data = 2;
            curr = curr.next;
            two--;
        }
        return head;
    }
}
