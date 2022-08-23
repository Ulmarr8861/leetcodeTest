package 排序;

public class 希尔排序 {
    //选择一个增量序列 t1，t2，……，tk，其中 ti > tj, tk = 1；
    // 按增量序列个数 k，对序列进行 k 趟排序；每趟排序，根据对应的增量 ti，
    // 将待排序列分割成若干长度为 m 的子序列，分别对各子表进行直接插入排序。
    // 仅增量因子为 1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。

    // 希尔排序
    public void sort(int[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }
}
