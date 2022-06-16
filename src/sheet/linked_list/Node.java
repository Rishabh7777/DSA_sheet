package sheet.linked_list;

public class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public static Node insert(Node head, int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        return head;
    }

    public static void printLL(NodeDoubly head) {
        if(head == null) {
            System.out.println("null");
            return;
        }
        while(head != null) {
            System.out.print(head.data);
            if(head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }
}