package 平常练习;

public class _1855下标中的最大距离 {
    public static void main(String[] args) {

    }

    // 暴力解法 超时
    public static int maxDistance(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int ans = 0;
        for (int i = 0; i < len1; i++) {
            for (int j = i; j < len2; j++) {
                if (nums1[i] <= nums2[j]) {
                    ans = Math.max(ans, j-i);
                }
            }
        }
        return ans;
    }
}
