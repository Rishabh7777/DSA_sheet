package sheet.linked_list;

import static sheet.linked_list.Reverse.reverseIterative;

public class AddTwoNumbers {
    public static Node addTwoLists2(Node first, Node second){
        if(first == null) {
            return second;
        }
        if(second == null) {
            return first;
        }
        //reversing both lists to simplify addition.
        first = reverseIterative(first);
        second = reverseIterative(second);
        Node sum = null;
        int carry = 0;
        //using a loop till both lists and carry gets exhausted.
        while( first != null || second != null || carry > 0 ) {
            //using a variable to store sum of two digits along with carry.
            int newVal = carry;
            //if nodes are left in any list, we add their data in newVal.
            if(first != null) newVal += first.data;
            if(second != null) newVal += second.data;
            //updating carry.
            carry = newVal / 10;
            //using modulus to store only a single digit at that place.
            newVal = newVal % 10;
            //creating new node which gets connected with other nodes that
            //we get after calculating sum of respective digits.
            Node newNode = new Node(newVal);
            //storing the previously made nodes in the link part of new node
            //creating the result LL in reverse order
            newNode.next = sum;
            //making the new node as the first node of all previously made node.
            sum = newNode;
            //moving ahead in both lists.
            if(first != null) first = first.next;
            if(second != null) second = second.next;
        }
        return sum;
    }
}
