package Leet;


public class Leet011 {
    public static void main(String[] args) {
        Leet011 l11 = new Leet011();
        int[] a = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(l11.maxArea2(a));
    }
    public int maxArea(int[] height) {
        if (height == null) {
            return 0;
        }
        int l = height.length;
        int h = 0, w = 0, max = 0;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                h = height[i] <= height[j] ? height[i] : height[j];
                w = j - i >= 0 ? j - i : i - j;
                max = w * h > max ? w * h : max;
            }
        }
        return max;
    }
    public int maxArea2(int[] height) {
        int l = height.length - 1;
        int left = 0, right = l;
        int maxValue = 0, area = 0;
        for (int i = 0; i < l; i++) {
            area = Math.min(height[left], height[right]) * (right - left);
            //area = height[left] <= height[right] ? height[left] * (right - left) : height[right] * (right - left);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
            //maxValue = Math.max(area, maxValue);
            maxValue = area > maxValue ? area : maxValue;
        }
        return maxValue;
    }
}
