package linearsearch;

public class LinearSearch {
    private LinearSearch() {
    }

    public static void main(String[] args) {
        int[]  data = {24,18,12,9,16,66,32, 4};
        int res = search(data, 16);
        System.out.println("res = " + res);

        int res2 = search(data, 666);
        System.out.println("res2 = " + res2);
    }

    public static int search(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
