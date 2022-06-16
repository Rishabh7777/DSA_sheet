package sheet.linked_list;

public class Problem32 {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data=data;
            this.next = null;
        }
    }

    public static long multiplyTwoLists(Node l1, Node l2){
        long sum1 = 0, sum2 = 0;
        while(l1 != null) {
            sum1 = (sum1 * 10) % 1000000007 + l1.data;
            l1 = l1.next;
        }
        while(l2 != null) {
            sum2 = (sum2 * 10) % 1000000007 + l2.data;
            l2 = l2.next;
        }
        return (sum1 * sum2) % 1000000007;
    }

    public static void main(String[] args) {
        Node l1 = new Node(3);
        l1.next = new Node(2);
        l1.next.next = new Node(5);

        Node l2 = new Node(2);
        l2.next = new Node(3);
        System.out.println(multiplyTwoLists(l1, l2));
    }
}
