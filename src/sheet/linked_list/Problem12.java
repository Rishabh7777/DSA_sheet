package sheet.linked_list;

//find starting node of two intersecting LL
public class Problem12 {
    public static int getNodeCount(Node head) {
        int count = 0;
        while(head != null) {
            count++;
            head = head.getNext();
        }
        return count;
    }

    public static Node helper(Node large, Node small, int diff) {
        //move pointer of large node by diff
        for(int i=0; i<diff; i++) {
            large = large.getNext();
        }
        //move both pointers together until they find a common node
        while(large != null && small != null) {
            if(large == small) {
                return large;
            }
            large = large.getNext();
            small = small.getNext();
        }
        return null;
    }

    public static int getIntersectingNode(Node first, Node second) {
        //get count of number of nodes in both LL
        int firstCount = getNodeCount(first);
        int secondCount = getNodeCount(second);
        //find the difference in number of nodes
        int diff = Math.abs(firstCount - secondCount);
        Node ret = null;
        if(firstCount > secondCount) {
            ret = helper(first, second, diff);
        } else {
            ret = helper(second, first, diff);
        }
        return (ret == null) ? -1 : ret.getData();
    }

    public static void main(String[] args) {
        Node node1 = new Node(3);
        Node node2 = new Node(6);
        Node node3 = new Node(9);
        Node node4 = new Node(15);
        Node node5 = new Node(20);
        Node node6 = new Node(10);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node6.setNext(node4);

        System.out.println(getIntersectingNode(node1, node6));
    }
}
