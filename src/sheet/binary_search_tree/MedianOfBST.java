package sheet.binary_search_tree;

public class MedianOfBST {
    private static int countNodes(Node root) {
        Node current, pre;
        current = root;
        int count = 0;
        while (current != null) {
            if (current.left == null) {
                count++;
                current = current.right;
            } else {
                pre = current.left;
                //get the rightmost node of left subtree before the current
                //or in-order predecessor of current
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }
                //make current as the right node of pre
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    //revert the changes made to the tree
                    //i.e. fix the right child of predecessor back to null
                    count++;
                    pre.right = null;
                    current = current.right;
                }
            }
        }
        return count;
    }

    public static float findMedian(Node root) {
        if(root == null) {
            return 0;
        }
        int count = countNodes(root);
        Node current, pre, prev = null;
        current = root;
        int currCount = 0;
        while (current != null) {
            if (current.left == null) {
                currCount++;
                if(count%2 != 0 && currCount == (count+1)/2) {
                    return (float)current.data;
                } else if(count%2 == 0 && currCount == (count/2)+1) {
                    return ((float)prev.data + (float)current.data) / 2;
                }
                prev = current;
                current = current.right;
            } else {
                pre = current.left;
                //get the rightmost node of left subtree before the current
                //or in-order predecessor of current
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }
                //make current as the right node of pre
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    //revert the changes made to the tree
                    //i.e. fix the right child of predecessor back to null
                    pre.right = null;
                    prev = pre;
                    currCount++;
                    if(count%2 != 0 && currCount == (count+1)/2) {
                        return (float)current.data;
                    } else if(count%2 == 0 && currCount == (count/2)+1) {
                        return ((float)prev.data + (float)current.data) / 2;
                    }
                    prev = current;
                    current = current.right;
                }
            }
        }
        return -1;
    }
}
