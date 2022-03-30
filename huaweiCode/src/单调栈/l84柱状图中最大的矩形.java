package 单调栈;

public class l84柱状图中最大的矩形 {
    public static void main(String[] args) {
        int a = new l84柱状图中最大的矩形().largestRectangleArea(new int[]{3, 1, 5, 6, 2});
        System.out.println(a);
    }
    public int largestRectangleArea(int[] heights) {
        int h = 0;
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = i-1;
            int right = i+1;
            h = heights[i];
            while (left >= 0 && heights[left] >= h) {
                left--;
            }
            while (right <= heights.length - 1 && heights[right] >= h) {
                right++;
            }
            if (left < 0) {
                left++;
            }
            if (right == heights.length) {
                right--;
            }
            if (heights[left] < h) {
                left++;
            }
            if (heights[right] < h) {
                right--;
            }
            ans = Math.max(ans, heights[i] * (right - left + 1));
        }
        return ans;
    }
}
