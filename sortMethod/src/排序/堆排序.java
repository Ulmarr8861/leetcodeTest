package 排序;

/**
 *创建一个堆 H[0……n-1]；
 * 把堆首（最大值）和堆尾互换；
 * 把堆的尺寸缩小 1，并调用 shift_down(0)，目的是把新的数组顶端数据调整到相应位置；
 * 重复步骤 2，直到堆的尺寸为 1
 */
public class 堆排序 {
    //堆排序
    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, n);
        }
        for (int j = n - 1; j > 0; j--) {
            swap(arr, 0, j);
            adjustHeap(arr, 0, j);
        }
    }

    private static void adjustHeap(int[] arr, int i, int n) {
        int temp = arr[i];
        for (int k = 2 * i + 1; k < n; k = 2 * k + 1) {
            if (k + 1 < n && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 5, 51, 2, 6, 23, 5, 123, 3};
        堆排序 s = new 堆排序();
        s.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
