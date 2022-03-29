package Leet022;

import java.util.ArrayList;
import java.util.List;

public class Leet022 {
    public static void main(String[] args) {
        Leet022 leet022 = new Leet022();
        List<String> ans = leet022.generateParenthesis(2);
        System.out.println("2222");

    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        addParenthesis(ans, n, 0, 0, new StringBuffer());
        return ans;
    }

    public void addParenthesis(List<String> ans, int n, int left, int right, StringBuffer tmp) {
        if (tmp.length() == n * 2) {
            ans.add(tmp.toString());
            return;
        }
        if (left < n) {
            tmp.append("(");
            addParenthesis(ans, n, left + 1, right, tmp);
            tmp.deleteCharAt(tmp.length() - 1);
        }
        if (right < left) {
            tmp.append(")");
            addParenthesis(ans, n, left, right + 1, tmp);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }
}
