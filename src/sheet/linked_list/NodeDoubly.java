package sheet.linked_list;

public class NodeDoubly {
    int data;
    NodeDoubly prev, next;

    public NodeDoubly(int data) {
        this.data = data;
        prev = null;
        next = null;
    }

    public static NodeDoubly insert(NodeDoubly head, int data) {
        NodeDoubly newNode = new NodeDoubly(data);
        if(head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        return head;
    }

    public static void printDLL(NodeDoubly head) {
        if(head == null) {
            System.out.println("null");
            return;
        }
        while(head != null) {
            System.out.print(head.data);
            if(head.next != null) {
                System.out.print(" <--> ");
            }
            head = head.next;
        }
        System.out.println();
    }
}
