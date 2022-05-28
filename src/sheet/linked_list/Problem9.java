package sheet.linked_list;

//add 1 to LL
public class Problem9 {
    public static int helper(Node node) {
        if(node == null) {
            return 1;
        }
        int temp = node.getData() + helper(node.getNext());
        node.setData(temp % 10);
        return temp / 10;
    }

    //recursive approach
    public static Node addOne(Node head) {
        int ret = helper(head);
        if(ret != 0) {
            Node newNode = new Node(ret);
            newNode.setNext(head);
            head = newNode;
        }
        return head;
    }

    public static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next;
        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        return prev;
    }

    //iterative approach
    public static Node addOne2(Node head) {
        head = reverse(head);
        Node curr = head;
        int carry = 1;
        while(true) {
            int temp = curr.getData() + 1;
            curr.setData(temp % 10);
            carry = temp / 10;
            if(carry == 0) {
                return reverse(head);
            }
            if(curr.getNext() == null) {
                break;
            } else {
                curr = curr.getNext();
            }
        }
        curr.setNext(new Node(1));
        return reverse(head);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(9);
        head.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        Problem1.printLL(head);
        head = addOne2(head);
        Problem1.printLL(head);
    }
}
