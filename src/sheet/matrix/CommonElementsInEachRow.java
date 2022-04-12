package sheet.matrix;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CommonElementsInEachRow {
    private static void find(int[][] matrix) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] ints : matrix) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < matrix[0].length; j++) {
                if (!set.contains(ints[j])) {
                    map.put(ints[j], map.getOrDefault(ints[j], 0) + 1);
                    set.add(ints[j]);
                }
            }
        }

        for(int num: map.keySet()) {
            if(map.get(num) == matrix.length) {
                System.out.print(num + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,1,4,8}, {3,7,8,5,1}, {8,7,7,3,1}, {8,1,2,7,9}};
        find(matrix);
    }
}
