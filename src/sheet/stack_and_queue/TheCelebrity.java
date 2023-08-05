package sheet.stack_and_queue;

import java.util.Stack;

public class TheCelebrity {
    // the celebrity row will have all 0's and the celebrity column will have all 1's
    private int celebrity(int[][] M, int n) {
        for(int i=0; i<n; i++) {
            int j = 0;
            while(j < n) {
                if(M[i][j] == 1) {
                    break;
                }
                j++;
            }

            if(j == n) {
                int k = 0;
                while(k < n) {
                    if(k == i) {
                        k++;
                        continue;
                    }
                    if(M[k][i] != 1) {
                        break;
                    }
                    k++;
                }

                if(k == n) {
                    return i;
                }
            }
        }

        return -1;
    } // O(n^2)

    int celebrityOptimised(int[][] M, int n) {
        // push all n values as celebrities into stack
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++) {
            st.push(i);
        }

        // take top two from stack and check if they know eash other
        // if both knew each other only one will be pushed back into stack
        while(st.size() > 1) {
            int a = st.pop();
            int b = st.pop();

            if(M[a][b] == 1) {
                st.push(b);
            } else if(M[b][a] == 1) {
                st.push(a);
            }
        }

        if(st.isEmpty()) {
            return -1;
        }

        // p can be the celebrity, will check it with 0's in row
        // and all 1's in all columns
        int p = st.pop();
        for(int i=0; i<n; i++) {
            if(M[p][i] == 1) {
                return -1;
            }
        }

        for(int i=0; i<n; i++) {
            if(i == p) {
                continue;
            }
            if(M[i][p] == 0) {
                return -1;
            }
        }

        return p;
    } // O(n)

    public static void main(String[] args) {
        int n = 2;
        int[][] M = {{0,1}, {1,0}};

        TheCelebrity obj = new TheCelebrity();
        System.out.println(obj.celebrity(M, n));
    }
}
