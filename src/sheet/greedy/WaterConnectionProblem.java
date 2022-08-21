package sheet.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WaterConnectionProblem {
    public static ArrayList<ArrayList<Integer>> solve(int n, int p, ArrayList<Integer> a , ArrayList<Integer> b , ArrayList<Integer> d) {
        //get all starting houses i.e. house with no incoming pipe
        int[] unvisited = new int[n - b.size()];
        int index = 0;
        for(int i=1; i<=n; i++) {
            if(!b.contains(i)) {
                unvisited[index++] = i;
            }
            if(index == unvisited.length) {
                break;
            }
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>(); //to store result
        for(int i: unvisited) {
            int minDiameter = Integer.MAX_VALUE, house = i;
            while(true) {
                index = a.indexOf(house);
                if(index == -1) {
                    break;
                }
                house = b.get(index);
                minDiameter = Math.min(minDiameter, d.get(index));
            } //O(p)
            if(i != house) {
                res.add(new ArrayList<>(Arrays.asList(i, house, minDiameter)));
            }
        }
        return res;
    } //O(n)

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int p = scan.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        ArrayList<Integer> d = new ArrayList<>();
        for(int i=0; i<p; i++) {
            int out = scan.nextInt();
            int in = scan.nextInt();
            int dia = scan.nextInt();
            a.add(out);
            b.add(in);
            d.add(dia);
        }
        scan.close();
        System.out.println(solve(n, p, a, b, d));
    }
}
