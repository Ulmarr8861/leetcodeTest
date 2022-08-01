package 排序;

public class 快速排序 {
    public static void quickSort(int[] arr,int left,int right){
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        int tmp = 0;
        //让比pivot值小的放左边，比pivot 值大的放右边
        while (l < r) {
            //在pivot的左边一直找，找到大于等于pivot值，才退出
            while (arr[l] < pivot) {
                l++;
            }
            //在pivot的右边一直找，找到小于等于pivot值，才退出
            while (arr[r] > pivot) {
                r--;
            }
            //如果l>=r说明pivot的左右两边的值，已经全部放好
            if (l >= r) {
                break;
            }

            //交换
            tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;

            //交换完成后，发现arr[l] == pviot值，r--
            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
        }
        //如果l==r，必须l++，r--,否则出现栈溢出
        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {
            quickSort(arr,left,r);
        }
        if (right > l) {
            quickSort(arr,l,right);
        }


    }


    public static void quickSort2(int[] arr,int left,int right) {

    }



        public static void main(String[] args){
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        quickSort2(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}