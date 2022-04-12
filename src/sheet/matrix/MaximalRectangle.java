package sheet.matrix;

import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangle {
    private static int findMaxRectangle(int[] heights) {
        // find prev smaller for each element
        Stack<Integer> st = new Stack<>();
        int[] prevSmaller = new int[heights.length];
        prevSmaller[0] = -1;
        st.push(0);
        for(int i=1; i<heights.length; i++) {
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }
            prevSmaller[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        // find next smaller for each element
        st.removeAllElements();
        int[] nextSmaller = new int[heights.length];
        Arrays.fill(nextSmaller, heights.length);
        st.push(0);
        for(int i=1; i<heights.length; i++) {
            while(!st.isEmpty() && heights[i] < heights[st.peek()]) {
                nextSmaller[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }

        int maxArea = Integer.MIN_VALUE;
        for(int i=0; i<heights.length; i++) {
            int area = (nextSmaller[i] - prevSmaller[i] - 1) * heights[i];
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static int maxArea(int[][] matrix, int n, int m) {
        if(matrix.length == 0) {
            return 0;
        }

        int[] heights = new int[m];
        int maxArea = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            // build histogram for each row
            for(int j=0; j<m; j++) {
                if(matrix[i][j] == 0) {
                    // histogram with base as 0, means no histogram
                    heights[j] = 0;
                } else {
                    heights[j]++;
                }
            }
            int area = findMaxRectangle(heights);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int n = 4, m = 4;
        int[][] matrix = {{0,1,1,0}, {1,1,1,1}, {1,1,1,1}, {1,1,0,0}};
        System.out.println(maxArea(matrix, n, m));
    }
}
