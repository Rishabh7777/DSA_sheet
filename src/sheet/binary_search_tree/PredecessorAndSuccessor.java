package sheet.binary_search_tree;

public class PredecessorAndSuccessor {
    public static Node findSuccessor(Node root, int key) {
        Node suc = null, curr = root;
        while(curr != null) {
            if(key < curr.data) {
                suc = curr;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return suc;
    } //O(h)

    public static Node findPredecessor(Node root, int key) {
        Node pred = null, curr = root;
        while(curr != null) {
            if(key > curr.data) {
                pred = curr;
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        return pred;
    } //O(h)
}
