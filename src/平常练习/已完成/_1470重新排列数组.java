package 平常练习.已完成;

public class _1470重新排列数组 {
    public static void main(String[] args) {
        int[] res = shuffle(new int[]{2,5,1,3,4,7},3);
        for (int i : res) {
            System.out.print(i+" ");
        }
    }

    /*
     * 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
     * 
     * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
     */
    public static int[] shuffle(int[] nums, int n) {
        int[] nums1 = new int[n];
        int[] nums2 = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = nums[i];
        }
        for (int i = n; i < 2 * n; i++) {
            nums2[i-n] = nums[i];
        }
        int j = 0;
        for (int i = 0; i < 2 * n; i += 2) {
            nums[i] = nums1[j];
            nums[i+1] = nums2[j++];
        }
        return nums;
    }
}
