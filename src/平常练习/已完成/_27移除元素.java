package 平常练习.已完成;

public class _27移除元素 {
    public static void main(String[] args) {
        
    }

    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        int slow=0;
        for (int fast = 0; fast < len; fast++) {
            if(nums[fast]!=val){
                nums[slow++]=nums[fast];
            }
        }
        return slow;
    }
}
