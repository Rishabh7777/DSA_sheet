package sheet.linked_list;

public class Problem10 {
    private static Node addTwoLists(Node first, Node second){
        //reverse both the LL
        first = Problem9.reverse(first);
        second = Problem9.reverse(second);
        //create head pointer of result LL
        Node head = new Node((first.getData() + second.getData()) % 10);
        //get initial carry, adding first two nodes of both LL
        int carry = (first.getData() + second.getData()) / 10;
        //move first and second pointers
        first = first.getNext();
        second = second.getNext();
        //use curr pointer to traverse the result node
        Node curr = head;
        //add two numbers represented by first and second pointers
        //put resultant number in result LL and update carry
        while(first != null && second != null) {
            int temp = first.getData() + second.getData() + carry;
            Node node = new Node(temp % 10);
            curr.setNext(node);
            curr = curr.getNext();
            carry = temp / 10;
            first = first.getNext();
            second = second.getNext();
        }
        //finish any LL if remaining
        while(first != null) {
            int temp = first.getData() + carry;
            Node node = new Node(temp % 10);
            curr.setNext(node);
            curr = curr.getNext();
            carry = temp / 10;
            first = first.getNext();
        }
        while(second != null) {
            int temp = second.getData() + carry;
            Node node = new Node(temp % 10);
            curr.setNext(node);
            curr = curr.getNext();
            carry = temp / 10;
            second = second.getNext();
        }
        //create a new node if there is a carry
        if(carry != 0) {
            curr.setNext(new Node(carry));
        }
        return Problem9.reverse(head);
    }

    //better written function
    public static Node addTwoLists2(Node first, Node second){
        //reversing both lists to simplify addition.
        first = Problem9.reverse(first);
        second = Problem9.reverse(second);
        Node sum = null;
        int carry = 0;
        //using a loop till both lists and carry gets exhausted.
        while( first != null || second != null || carry > 0 ) {
            //using a variable to store sum of two digits along with carry.
            int newVal = carry;
            //if nodes are left in any list, we add their data in newVal.
            if(first != null) newVal += first.getData();
            if(second != null) newVal += second.getData();
            //updating carry.
            carry = newVal / 10;
            //using modulus to store only a single digit at that place.
            newVal = newVal % 10;
            //creating new node which gets connected with other nodes that
            //we get after calculating sum of respective digits.
            Node newNode = new Node(newVal);
            //storing the previously made nodes in the link part of new node
            //creating the result LL in reverse order
            newNode.setNext(sum);
            //making the new node as the first node of all previously made node.
            sum = newNode;
            //moving ahead in both lists.
            if(first != null) first = first.getNext();
            if(second != null) second = second.getNext();
        }
        return sum;
    }

    public static void main(String[] args) {
        Node first = new Node(3);
        Node node2 = new Node(4);
        Node node3 = new Node(5);
        first.setNext(node2);
        node2.setNext(node3);

        Node second = new Node(4);
        second.setNext(new Node(5));

        Node head = addTwoLists(first, second);
        Problem1.printLL(head);
    }
}
