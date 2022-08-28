package 平常练习.已完成;

public class _189轮转数组 {
    public static void main(String[] args) {
        int[] res = rotate(new int[]{1,2,3,4,5,6,7}, 3);
        for (int i : res) {
            System.out.print(i+" ");
        }
    }

    /*
     * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
     */
    public static int[] rotate(int[] nums, int k) {
        //找规律的题，
        int len = nums.length;
        //移动 1 个与移动 1 + len 个的情况是一样的
        int tempLen = k % len;
        int[] temp = new int[tempLen];
        //移动时最后 tempLen 个元素存到临时数组里
        for (int i = 0; i < tempLen; i++) {
            temp[i] = nums[len - tempLen + i];
        }
        //前面的每个单位向后移动 tempLen 个单位
        for (int i = len-1; i >= tempLen; i--) {
            nums[i] = nums[i - tempLen];
        }
        //将临时数组的数据存入到原始数组中
        for (int i = 0; i < tempLen; i++) {
            nums[i] = temp[i];
        }

        return nums;
    }
}
