package sheet.linked_list;

import java.util.Stack;

public class Problem18 {
    public static boolean isPalindrome(Node head) {
        //find number of nodes in LL
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
