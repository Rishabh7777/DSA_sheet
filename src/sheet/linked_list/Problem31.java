package sheet.linked_list;

public class Problem31 {
    static class Node {
        int data;
        Node next;
        Node(int key) {
            data = key;
            next = null;
        }
    }

    private static Node merge(Node left, Node right) {
        //create a dummy node
        Node merged = new Node(-1);
        Node temp = merged;
        while (left != null && right != null) {
            if (left.data < right.data) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        // process the unfinished nodes
        while (left != null) {
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }
        while (right != null) {
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }
        //returning after node -1 (first node)
        return merged.next;
    }

    Node mergeKList(Node[] arr, int K) {
        for(int i=0; i<K-1; i++) {
            arr[i+1] = merge(arr[i], arr[i+1]);
        }
        return arr[K-1];
    }
}
