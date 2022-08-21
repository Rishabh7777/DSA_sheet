package sheet.linked_list;

import java.util.Stack;

public class CheckPalindrome {
    public static boolean isPalindrome(Node head) {
        //count the number of nodes in LL
        int size = 0;
        Node curr = head;
        while(curr != null) {
            size++;
            curr = curr.next;
        }
        curr = head;
        Stack<Integer> st = new Stack<>();
        //push half nodes to stack and then compare them with other half
        for(int i=0; i<size/2; i++) {
            st.push(curr.data);
            curr = curr.next;
        }
        // if LL has odd number of nodes, then middle node is skipped to check
        // as left of middle is compared to the right of middle
        if(size % 2 != 0) {
            curr = curr.next;
        }
        while(curr != null) {
            if(curr.data == st.peek()) {
                st.pop();
            } else {
                return false;
            }
            curr = curr.next;
        }
        return true;
    }
}
