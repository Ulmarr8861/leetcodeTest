package 排序;

public class 基数排序 {
    // 将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零
    //从最低位开始，依次进行一次排序
    //从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列
    // radix sort
    public void sort(int[] arr) {
        int n = arr.length;
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int base = 1;
        while (max / base > 0) {
            int[] bucket = new int[10];
            for (int i = 0; i < n; i++) {
                bucket[(arr[i] / base) % 10]++;
            }
            for (int i = 1; i < 10; i++) {
                bucket[i] += bucket[i - 1];
            }
            int[] temp = new int[n];
            for (int i = n - 1; i >= 0; i--) {
                temp[--bucket[(arr[i] / base) % 10]] = arr[i];
            }
            for (int i = 0; i < n; i++) {
                arr[i] = temp[i];
            }
            base *= 10;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 5, 51, 2, 6, 23, 5, 123, 3};
        基数排序 s = new 基数排序();
        s.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
