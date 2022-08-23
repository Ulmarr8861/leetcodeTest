package 排序;

/**
 * 从数列中挑出一个元素，称为 “基准”（pivot）;
 * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
 * 在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序；
 *
 * 链接：https://www.zhihu.com/question/34814570/answer/656281124
 */
public class 快速排序 {
    //https://blog.csdn.net/weixin_43586713/article/details/119820797
    public static void quickSort2(int[] nums, int start, int end){
        if(start>end) return;
        int i,j,base;
        i=start;
        j=end;
        base=nums[start];
        while (i<j){
            while (i<j && nums[j]>=base) j--;
            while (i<j && nums[i]<=base) i++;
            if(i<j){
                swap(nums,i,j);
            }
        }
        swap(nums,start,i);
        quickSort(nums,start,j-1);
        quickSort(nums,j+1,end);
    }
    public static void swap(int[] nums,int left,int right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }


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






        public static void main(String[] args){
        int[] arr = {6,1,2,3,5};
        quickSort2(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}