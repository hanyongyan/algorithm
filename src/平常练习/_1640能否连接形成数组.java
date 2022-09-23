package 平常练习;

import java.util.HashMap;
import java.util.Map;

public class _1640能否连接形成数组 {
    public static void main(String[] args) {
        // System.out.println(canFormArray(new int[]{49,18,16}, new
        // int[][]{{16,18,49}}));
        System.out.println(canFormArray(new int[] { 91, 4, 64, 78 }, new int[][] { { 78 }, { 4, 64 }, { 91 } }));
    }

    public static boolean canFormArray(int[] arr, int[][] pieces) {
        int n = arr.length, m = pieces.length;
        Map<Integer, Integer> index = new HashMap<Integer, Integer>();
        // 由题意可知 应先导入 二维坐标的第一个值  ，因为二位坐标中的每一行与arr中的某些元素都是对应的
        for (int i = 0; i < m; i++) {
            index.put(pieces[i][0], i);
        }
        for (int i = 0; i < n;) {
            // 如果map中不包含此键，肯定就是查找失败了，往下继续看就可知 每次对比的就应该是二维表中
            if (!index.containsKey(arr[i])) {
                return false;
            }
            int j = index.get(arr[i]), len = pieces[j].length;
            for (int k = 0; k < len; k++) {
                if (arr[i + k] != pieces[j][k]) {
                    return false;
                }
            }
            i = i + len;
        }
        return true;

    }
}
