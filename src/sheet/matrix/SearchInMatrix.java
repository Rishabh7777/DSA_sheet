package sheet.matrix;

public class SearchInMatrix {
    private static boolean search(int[][] matrix, int row, int target) {
        int lowC = 0, highC = matrix[0].length;
        while(lowC <= highC) {
            int midC = (lowC + highC) / 2;
            if(target == matrix[row][midC]) {
                return true;
            } else if(target < matrix[row][midC]) {
                highC = midC - 1;
            } else {
                lowC = midC + 1;
            }
        }
        return false;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int lowR = 0, highR = matrix.length-1;
        while(lowR <= highR) {
            int midR = (lowR + highR) / 2;
            if(target == matrix[midR][0]) {
                return true;
            } else if(target < matrix[midR][0]) {
                highR = midR - 1;
            } else if(target > matrix[midR][0] && target <= matrix[midR][matrix[0].length-1]) {
                return search(matrix, midR, target);
            } else {
                lowR = midR + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
        System.out.println(searchMatrix(matrix, 99));
    }
}
