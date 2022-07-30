package sheet.binary_search_tree;

public class Problem2 {
    public Node deleteNode(Node root, int key) {
        if(root == null) {
            return null;
        }
        if(key < root.data) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if(key > root.data) {
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            //key is leaf node
            if(root.left == null && root.right == null) {
                return null;
            }
            if(root.right == null) {
                return root.left;
            } else {
                //either right subtree or both subtrees are present
                Node curr = root.right, prev = null;
                //find leftmost node of right subtree
                while(curr.left != null) {
                    prev = curr;
                    curr = curr.left;
                }
                //if right subtree has only one node
                if(prev == null) {
                    curr.left = root.left;
                    return curr;
                }
                //else
                prev.left = curr.right;
                curr.left = root.left;
                curr.right = root.right;
                return curr;
            }
        }
    }
}
