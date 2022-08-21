package sheet.greedy;

public class PageFaultsLRU {
    //will use linked list to form LRU cache
    private static class LL {
        int data;
        LL next, prev;
        public LL(int data) {
            this.data = data;
        }
        public String toString() {
            return "data = " + this.data;
        }
    }

    public static int pageFaults(int N, int C, int[] pages) {
        //insert first page in cache
        LL head = new LL(pages[0]);
        int cacheSize = 1, pageFaults = 1;
        for(int i=1; i<N; i++) {
            LL temp = head, previous = head;
            //traverse through LL and check if present page already exists in cache or not
            while(temp != null) {
                if(temp.data == pages[i]) {
                    //page found
                    break;
                } else {
                    previous = temp;
                    temp = temp.next;
                }
            }
            if(temp != null) {
                //found similar page in cache, so make it most recent used page (head of LL)
                if(temp.prev == null) {
                    continue;
                }
                if(temp.next != null) {
                    temp.next.prev = previous;
                }
                previous.next = temp.next;
                temp.prev = null;
                temp.next = head;
                head.prev = temp;
                head = temp;
            } else if(cacheSize < C) {
                //cache can hold more pages, so insert current page in cache
                LL node = new LL(pages[i]);
                node.next = head;
                head.prev = node;
                head = node;
                cacheSize++;
                pageFaults++;
            } else {
                //replace least used page (tail of LL) with current page
                previous.prev.next = null;
                previous.prev = null;
                LL node = new LL(pages[i]);
                node.next = head;
                head.prev = node;
                head = node;
                pageFaults++;
            }
        }
        return pageFaults;
    }

    public static void main(String[] args) {
        int n = 9, c = 4;
        int[] pages = {5, 0, 1, 3, 2, 4, 1, 0, 5};
        System.out.println(pageFaults(n, c, pages));
    }
}
