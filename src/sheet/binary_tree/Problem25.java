package sheet.binary_tree;

import java.util.HashMap;
import java.util.Stack;

public class Problem25 {
    public static int checkMirrorTree(int n, int e, int[] A, int[] B) {
        HashMap<Integer, Stack<Integer>> map = new HashMap<>();
        //traverse on A[] and create stack for each node with children
        for(int i=0; i<2*e; i=i+2) {
            Stack<Integer> st = map.getOrDefault(A[i], new Stack<>());
            st.push(A[i+1]);
            map.put(A[i], st);
        }
        //traverse on B[] and check if each element matches with top of stack or not
        for(int i=0; i<2*e; i=i+2) {
            Stack<Integer> st = map.get(B[i]);
            if(B[i+1] != st.pop()) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int n = 3, e = 2;
        int[] A = {1, 2, 1, 3};
        int[] B = {1, 3, 1, 2};
        System.out.println(checkMirrorTree(n, e, A, B));
    }
}
