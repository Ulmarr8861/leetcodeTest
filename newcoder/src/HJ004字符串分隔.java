import java.util.*;
public class HJ004字符串分隔 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int l = s.length() / 8;
        int k = s.length() % 8;
        StringBuffer buffer = new StringBuffer();
        buffer.append(s);
        if (k != 0) {
            for (int i = 0; i < 8-k; i++) {
                buffer.append(0);
            }
            l++;
        }
        s = buffer.toString();
        for (int i = 0; i < l; i++) {
            System.out.println(s.substring(i * 8, (i + 1) * 8));
        }
    }
}
