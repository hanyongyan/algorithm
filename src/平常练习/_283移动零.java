package 平常练习;

public class _283移动零 {
    public static void main(String[] args) {
        int[] res1 = moveZeroes(new int[] { 0, 1, 0, 3, 12 });
        for (int i : res1) {
            System.out.print(i + " ");
        }
        System.out.println();
        int[] res2 = ways2(new int[] { 0, 1, 0, 3, 12 });
        for (int i : res2) {
            System.out.print(i + " ");
        }

    }

    /*
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     */
    public static int[] moveZeroes(int[] nums) {
        int len = nums.length;
        int j = 0;
        // 遇到非0就往前提，从0...往后依次填写，j代表碰到非零是提到的位置
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }

        }
        for (int i = j; i < len; i++) {
            nums[i] = 0;
        }
        return nums;
    }

    public static int[] ways2(int[] nums) {
        int len = nums.length;
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0 && nums[j] != 0) {
                j++;
            } else if (nums[i] == 0 && nums[j] == 0) {
                continue;
            } else if (nums[i] != 0 && nums[j] == 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }

        }
        return nums;
    }
}
