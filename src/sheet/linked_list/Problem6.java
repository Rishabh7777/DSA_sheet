package sheet.linked_list;

public class Problem6 {
    //remove duplicate values from sorted LL
    public static void removeDuplicates(Node head) {
        Node curr = head;
        while(curr.next != null) {
            if(curr.data == curr.next.data) {
                Node temp = curr.next;
                curr.next = curr.next.next;
                temp.next = null;
                continue;
            }
            curr = curr.next;
        }
    } //O(n)

    public static void main(String[] args) {
        Node head = null;
        head = Node.insert(head, 5);
        head = Node.insert(head, 4);
        head = Node.insert(head, 2);
        head = Node.insert(head, 2);

        Problem1.printLL(head);
        removeDuplicates(head);
        Problem1.printLL(head);
    }
}
