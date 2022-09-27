package 平常练习.已完成;

public class _852山脉数组的峰顶索引 {
    public static void main(String[] args) {

    }

    /*
     * 符合下列属性的数组 arr 称为 山脉数组 ：
     * arr.length >= 3
     * 存在 i（0 < i < arr.length - 1）使得：
     * arr[0] < arr[1] < ... arr[i-1] < arr[i]
     * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
     * 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i +
     * 1] > ... > arr[arr.length - 1] 的下标 i 。
     */
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 2;
        int mid = 0;
        int ans = 0;
        while (left <= right) {
            // 由题意知 所求值是最大的 右边的依次减小 左边的也是依次减小
            // 如果当前位置的值大于下一个位置的值 当前位置可能是 所求的结果 所以使用 ans 来记录当前的位置
            // 如果当前位置不大于下一个位置，由题意当前位置肯定是小于下一个位置的值，所以对 left = mid + 1
            mid = (right + left) / 2;
            if (arr[mid] > arr[mid + 1]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    // 1 2 3 4 5 6 5 4 3 2 1

    // 最垃圾的方法
    public static int process(int[] arr) {
        int min = 0;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > min) {
                min = arr[i];
                index = i;
            }
        }
        return index;
    }
}
