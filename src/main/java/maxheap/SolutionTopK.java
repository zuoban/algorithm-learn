package maxheap;

public class SolutionTopK {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.enqueue(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {

            if (!pq.isEmpty() && arr[i] < pq.getFront()) {
                pq.dequeue();
                pq.enqueue(arr[i]);
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.dequeue();
        }
        return res;
    }

    public static void main(String[] args) {
        SolutionTopK solutionTopK = new SolutionTopK();
    }
}
