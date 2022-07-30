package sheet.binary_search_tree;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

import static sheet.binary_search_tree.BST.*;
import static sheet.binary_search_tree.PredecessorAndSuccessor.findSuccessor;

public class ReplaceWithSuccessor {
    public static void main(String[] args) {
        int[] arr = {8, 58, 71, 18, 31, 32, 63, 92, 43, 3, 91, 93, 25, 80, 28};
        Node root = null;
        for(int i=arr.length-1; i>=0; i--) {
            root = insert(root, arr[i]); //O(h)
            Node ret = findSuccessor(root, arr[i]); //O(h)
            if(ret == null) {
                arr[i] = -1;
            } else {
                arr[i] = ret.data;
            }
        } //O(h)
        System.out.println(Arrays.toString(arr));
    }
}
