package sheet.greedy;

class MinCashFlow {
    //will return the index of minimum net amount
    private static int getMin(int[] arr, int n) {
        int minInd = 0;
        for (int i = 1; i < n; i++) {
            if(arr[i] < arr[minInd]) {
                minInd = i;
            }
        }
        return minInd;
    } //O(n)

    //will return the index of maximum net amount
    private static int getMax(int[] arr, int n) {
        int maxInd = 0;
        for (int i = 1; i < n; i++) {
            if(arr[i] > arr[maxInd]) {
                maxInd = i;
            }
        }
        return maxInd;
    } //O(n)

    //select minimum of maxCredit and maxDebit value
    private static int minOf2(int x, int y) {
        return Math.min(x, y);
    } //O(1)

    // amount[p] indicates the net amount to be credited/debited to/from person 'p'
    private static void minCashFlowRec(int[] amount, int n) {
        // Find the indexes of minimum and maximum values in amount[]
        // amount[mxCredit] indicates the maximum amount to be given (or credited) to any person .
        // And amount[mxDebit] indicates the maximum amount to be taken(or debited) from any person.
        // So if there is a positive value in amount[], then there must be a negative value
        int mxCredit = getMax(amount, n), mxDebit = getMin(amount, n);

        // If both amounts are 0, then all amounts are settled
        if (amount[mxCredit] == 0 && amount[mxDebit] == 0) {
            return;
        }

        // Find the minimum of two amounts
        int min = minOf2(-amount[mxDebit], amount[mxCredit]);
        amount[mxCredit] -= min;
        amount[mxDebit] += min;

        // If minimum is the maximum amount to be
        System.out.println("Person " + mxDebit + " pays " + min + " to " + "Person " + mxCredit);

        // Recur for the amount array.
        // Note that it is guaranteed that the recursion would terminate as either amount[mxCredit] or
        // amount[mxDebit] becomes 0
        minCashFlowRec(amount, n);
    }

    // Given a set of persons as graph[] where graph[i][j] indicates the amount that person i needs to
    // pay person j
    public static void minCashFlow(int[][] graph) {
        // Create an array amount[],
        // initialize all value in it as 0.
        int n = 3;
        int[] amount = new int[n];

        // Calculate the net amount to be paid to person 'p', and stores it in amount[p].
        // The value of amount[p] can be calculated by subtracting debts of 'p' from credits of 'p'
        for (int p = 0; p < n; p++) {
            for(int i = 0; i < n; i++) {
                amount[p] += (graph[i][p] - graph[p][i]);
            }
        }

        minCashFlowRec(amount, n);
    } //O(n ^ 2)

    public static void main (String[] args) {
        // graph[i][j] indicates the amount
        // that person i needs to pay person j
        int[][] graph = {{0, 1000, 2000}, {0, 0, 5000}, {0, 0, 0}};

        // Print the solution
        minCashFlow(graph);
    }
}
