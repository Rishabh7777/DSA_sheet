package sheet.linked_list;

//detect loop in the linked list
public class Problem3 {
    //use two pointers
    public static boolean isLoopPresent(Node head) {
        if(head == null) {
            return false;
        }
        Node slow = head, fast = head.getNext();
        while(slow != fast) {
            if(fast == null || fast.getNext() == null) {
                return false;
            }
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        head.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node2);

        System.out.println(isLoopPresent(head));
    }
}
