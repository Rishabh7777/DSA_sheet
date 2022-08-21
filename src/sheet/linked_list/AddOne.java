package sheet.linked_list;

import static sheet.linked_list.Reverse.reverseIterative;

public class AddOne {
    public static int helper(Node node) {
        if(node == null) {
            return 1;
        }
        int temp = node.data + helper(node.next);
        node.data = temp % 10;
        return temp / 10;
    }

    public static Node addOneRecursive(Node head) {
        int ret = helper(head);
        if(ret != 0) {
            Node newNode = new Node(ret);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }

    public static Node addOneIterative(Node head) {
        // reverse the LL
        head = reverseIterative(head);
        Node curr = head;
        int carry;
        while(true) {
            int temp = curr.data + 1;
            curr.data = temp % 10;
            carry = temp / 10;
            if(carry == 0) {
                return reverseIterative(head);
            }
            if(curr.next == null) {
                break;
            } else {
                curr = curr.next;
            }
        }
        curr.next = new Node(1);
        return reverseIterative(head);
    }
}
