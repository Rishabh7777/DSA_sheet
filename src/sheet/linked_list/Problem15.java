package sheet.linked_list;

public class Problem15 {
    public static Node middleNode(Node head) {
        Node curr = head;
        int count = 0;
        while(curr != null) {
            count++;
            curr = curr.next;
        }
        curr = head;
        for(int i=0; i<count/2; i++) {
            curr = curr.next;
        }
        return curr;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        head.next = node2;
        node2.next = node3;

        Problem1.printLL(head);
        System.out.println(middleNode(head).data);
    }
}
