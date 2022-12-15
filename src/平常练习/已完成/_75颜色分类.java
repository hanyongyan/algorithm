package 平常练习.已完成;

public class _75颜色分类 {
    public static void main(String[] args) {
        process2(new int[] {2, 2, 0 });
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

    public static void process2(int[] nums) {
        int len = nums.length;
        int redIndex = 0;
        int blueIndex = len - 1;
        int temp = 0;
        for (int i = 0; i < len; i++) {
            if (i >= blueIndex) {
                break;
            }
            // 如果当前数为 0，就放到最开始的位置
            if (nums[i] == 0) {
                temp = nums[i];
                nums[i] = nums[redIndex];
                nums[redIndex] = temp;
                redIndex++;
            }
            // 如果当前数为 2，就放到最后面的位置
            else if (nums[i] == 2) {
                temp = nums[i];
                if(nums[blueIndex] == 0){
                    nums[i] = nums[redIndex];
                    nums[redIndex] = nums[blueIndex];
                    nums[blueIndex] = temp;
                    redIndex++;
                }else{
                    nums[i] = nums[blueIndex];
                    nums[blueIndex] = temp;
                }
                blueIndex--;
            }
        }
        System.out.println("排序完成");
    }
}
