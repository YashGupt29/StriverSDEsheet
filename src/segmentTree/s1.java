package segmentTree;

public class s1 {
    public static void main(String[] args) {
        int[] inputArr = {1, 3, 5, 7, 9, 11};
        n = inputArr.length;
        arr = inputArr;
        segment = new int[4 * n];
        build(0, 0, n - 1);

        int maxInRange = query(0, 0, n - 1, 1, 4);
        System.out.println("Maximum in range [1, 4]: " + maxInRange);
    }

    static int n = 10005;
    static int[] segment = new int[2 * n];
    static int[] arr = new int[n];

    private static void build(int index, int low, int high) {
        if (low == high) {
            segment[index] = arr[low];
            return;
        }
        int mid = (low + high) / 2;
        build(2 * index + 1, low, mid);
        build(2 * index + 2, mid + 1, high);
        segment[index] = Math.max(segment[2 * index + 1], segment[2 * index + 2]);
    }

    private static int query(int index, int low, int high, int l, int r) {
        if (low >= l && high <= r) {
            return segment[index];
        }
        if (high < l || low > r) {
            return Integer.MIN_VALUE;
        }
        int mid = (low + high) / 2;
        int left = query(2 * index + 1, low, mid, l, r);
        int right = query(2 * index + 2, mid + 1, high, l, r);
        return Math.max(left, right);
    }
    private static int querySum(int index, int low, int high, int l, int r) {
        if (low >= l && high <= r) {
            return segment[index];
        }
        if (high < l || low > r) {
            return 0;
        }
        int mid = (low + high) / 2;
        int left = querySum(2 * index + 1, low, mid, l, r);
        int right = querySum(2 * index + 2, mid + 1, high, l, r);
        return left + right;
    }

}
