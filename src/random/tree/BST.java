package random.tree;

public class BST {
    private TreeNode root;

    public TreeNode getRoot() {
        return this.root;
    }

    public void insert(int val) {
        if(this.root == null) {
            this.root = new TreeNode(val);
            return;
        }

        insertIntoBST(this.root, val);
    }

    private void insertIntoBST(TreeNode root, int val) {
        if(val < root.val) {
            //left
            if(root.left != null) {
                insertIntoBST(root.left, val);
            } else {
                root.left = new TreeNode(val);
            }
        } else {
            //right
            if(root.right != null) {
                insertIntoBST(root.right, val);
            } else {
                root.right = new TreeNode(val);
            }
        }
    }

    public void inOrderDisplay() {
        displayBSTInOrder(root);
        System.out.println();
    }

    private void displayBSTInOrder(TreeNode root) {
        if(root == null) {
            return;
        }

        //call left sub-tree
        displayBSTInOrder(root.left);
        //print current node value
        System.out.print(root.val + " ");
        //call right sub-tree
        displayBSTInOrder(root.right);
    }

    public TreeNode delete(int key) {
        return this.root = deleteFromBST(this.root, key);
    }

    private TreeNode deleteFromBST(TreeNode root, int key) {
        //when key is not present in tree
        if(root == null) {
            return null;
        }

        if(key < root.val) {
            root.left = deleteFromBST(root.left, key);
            return root;
        } else if(key > root.val) {
            root.right = deleteFromBST(root.right, key);
            return root;
        } else {
            //key is leaf node
            if(root.left == null && root.right == null) {
                return null;
            }
            //left subtree is present, find rightmost node in left subtree
            if(root.right == null) {
                return root.left;
            } else {
                //either right subtree or both subtrees are present
                TreeNode curr = root.right, prev = null;
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
