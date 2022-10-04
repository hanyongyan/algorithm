package 平常练习;

public class _1539第k个缺失的正整数 {
    public static void main(String[] args) {
        System.out.println(findKthPositive(new int[]{2,3,4,7,11}, 5));
    }

    public static int findKthPositive(int[] arr, int k) {
        int missCount = 0, lastMiss = -1, current = 1, ptr = 0; 
        for (missCount = 0; missCount < k; ++current) {
            if (current == arr[ptr]) {
                ptr = (ptr + 1 < arr.length) ? ptr + 1 : ptr;
            } else {
                ++missCount;
                lastMiss = current;
            }
        }
        return lastMiss;
    }
}
