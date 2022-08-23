package Leet;

import java.util.ArrayList;
import java.util.List;

public class Leet006 {
    public static void main(String[] args) {
        Leet006 l6 = new Leet006();
        String result = l6.convert3("PAYPALISHIRING", 5);
        System.out.println(result);

    }
    //不对，还没完善！
    public String convert(String s, int numRows) {
        StringBuffer result = new StringBuffer();
        if (numRows <= 1) {
            result = result.append(s);
            return result.toString();
        }
        int index;
        int j;
        for (int i = 0; i < numRows; i++) {
            j = 0;
            index = i + (numRows * 2 - 2) * j;
            if (j == 0) {
                result.append(s.charAt(i));
            }
            if (i != numRows - 1) {
                index = index + ((2 * numRows - 2) - 2 * i);
            }

            while (index < s.length()) {
                result.append(s.charAt(index));
                if ((index + 2 * i) < s.length() && i != 0 && i != numRows - 1) {
                    index = index + 2 * i;
                    result.append(s.charAt(index));
                }
                index = index + ((2 * numRows - 2) - 2 * i);
            }
        }
        return result.toString();
    }

    public String convert2(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
        public String convert3(String s, int numRows) {

            if (numRows == 1) return s;

            List<StringBuilder> rows = new ArrayList<>();
            for (int i = 0; i < Math.min(numRows, s.length()); i++)
                rows.add(new StringBuilder());

            int curRow = 0;
            boolean goingDown = false;

            for (char c : s.toCharArray()) {
                rows.get(curRow).append(c);
                if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
                curRow += goingDown ? 1 : -1;
            }

            StringBuilder ret = new StringBuilder();
            for (StringBuilder row : rows) ret.append(row);
            return ret.toString();
        }
}
