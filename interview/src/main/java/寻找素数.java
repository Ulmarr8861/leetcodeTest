import java.util.ArrayList;

public class 寻找素数 {
    public ArrayList<Integer> findPrimeNumber (int m, int n) {
        // write code here
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = m; i <= n; i++) {
            if (isPrime(i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    private boolean isPrime(int i) {
        if (i <= 3) {
            return i !=2 ;
        }
        for (int j = 2; j < i; j++) {
            if (i % j == 0) {
                return false;
            }

        }
        return true;
    }
}
