package 递归;

public class l509斐波那契数 {
    public static void main(String[] args) {
        l509斐波那契数 l = new l509斐波那契数();
        int re = l.fib(3);
        System.out.println();
    }
    public int fib(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        if (n <= 1) {
            return nums[n];
        }
        for (int i = 2; i <= n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n];
    }
}
