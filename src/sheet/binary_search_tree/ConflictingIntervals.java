package sheet.binary_search_tree;

import static sheet.binary_search_tree.IntervalTree.*;

public class ConflictingIntervals {
    public static IntervalTree.Node isConflicting(IntervalTree.Node root, Interval x) {
        //check if current interval x overlaps with tree
        Interval ret = isOverlapping(root, x);
        if(ret.low != -1) {
            //x is overlapping with some interval in the tree
            System.out.println(x + " conflicts with " + ret);
        }
        //insert x into the tree
        return insert(root, x);
    }

    public static void main(String[] args) {
        IntervalTree.Node root = isConflicting(null, new Interval(1, 5));
        root = isConflicting(root, new Interval(3, 7));
        root = isConflicting(root, new Interval(2, 6));
        root = isConflicting(root, new Interval(10, 15));
        root = isConflicting(root, new Interval(5, 6));
        root = isConflicting(root, new Interval(4, 100));
    }
}
