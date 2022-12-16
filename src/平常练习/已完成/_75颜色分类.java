package 平常练习.已完成;

public class _75颜色分类 {
    public static void main(String[] args) {
        sortColors(new int[] {2, 2, 0 });
    }

    // 此题就是进行原地排序
    public static void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; ++i) {
            // 如果当前数为 1 ，就放到 p1 的位置
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                ++p1;
            }
            // 当前数为 0 ，就放到 p0 的位置
            else if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                // p0 < p1 说明，说明当前 p0 位置的数为 1，就需要将
                if (p0 < p1) {
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                }
                ++p0;
                ++p1;
            }
        }
    }

}