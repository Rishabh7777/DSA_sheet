package sheet.stack_and_queue;

public class CircularTour {
    int tour(int[] petrol, int[] distance) {
        // starting point of the cycle
        int start = 0;
        // store previous deficiency of petrol from point A to B
        int deficit = 0;
        // current petrol balance
        int balance = 0;

        // will travel each node only once
        // if at any point petrol balance becomes -ve, store its deficit
        // and check from remaining balance at last if possible to cover the deficit
        for(int i=0; i<petrol.length; i++) {
            balance = balance + petrol[i] - distance[i];
            if(balance < 0) {
                deficit += balance;
                start = i + 1;
                balance = 0;
            }
        }

        return (deficit + balance >= 0) ? start : -1;
    }
}
