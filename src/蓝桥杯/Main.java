package 蓝桥杯;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // Scanner sc = new Scanner(System.in);
    // int n = sc.nextInt();
    // int[][] arr = new int[n][2];
    int[][] arr = { { 117590, 173621 }, { 45060, 118812 }, { 71296, 101768 }, { 89958, 174054 }, { 38588, 89652 } };
    // for (int i = 0; i < 5; i++) {
    // for (int j = 0; j < 2; j++) {
    // arr[i][j] = sc.nextInt();
    // }
    // }
    // 首先按照第二列进行排序 第二列相同时使用第一列排序
    Arrays.sort(arr, (int[] a, int[] b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
    // int res = 1;
    // for (int i = 1; i < 5; i++) {
    //   if (arr[i][0] >= arr[i - 1][0] && arr[i][0] <= arr[i - 1][1]) {
    //     continue;
    //   } else
    //     res++;
    // }
    // System.out.println(res);
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 2; j++) {
        System.out.print(arr[i][j]+" ");
      }
      System.out.println();
    }
  }
}