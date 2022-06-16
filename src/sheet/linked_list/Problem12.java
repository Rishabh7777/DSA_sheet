package sheet.linked_list;

//find starting node of two intersecting LL
public class Problem12 {
    private static int getNodeCount(Node head) {
        int count = 0;
        while(head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    private static Node helper(Node large, Node small, int diff) {
        //move pointer of large node by diff
        for(int i=0; i<diff; i++) {
            large = large.next;
        }
        //move both pointers together until they find a common node
        while(large != null && small != null) {
            if(large == small) {
                return large;
            }
            large = large.next;
            small = small.next;
        }
        return null;
    }

    public static int getIntersectingNode(Node first, Node second) {
        //get count of number of nodes in both LL
        int firstCount = getNodeCount(first);
        int secondCount = getNodeCount(second);
        //find the difference in number of nodes
        int diff = Math.abs(firstCount - secondCount);
        Node ret;
        if(firstCount > secondCount) {
            ret = helper(first, second, diff);
        } else {
            ret = helper(second, first, diff);
        }
        return (ret == null) ? -1 : ret.data;
    }
}
