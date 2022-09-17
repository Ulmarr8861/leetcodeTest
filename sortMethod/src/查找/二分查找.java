package 查找;
public class 二分查找 {

    //binarySearch
    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midValue = arr[mid];

        if (findVal > midValue) {
        }
        return 1;
    }
}
