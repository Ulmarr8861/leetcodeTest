import java.util.Scanner;

public class HJ001字符串最后一个单词的长度 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int len = s.length();
        int lastIndex = -1;
        if (s == null || "".equals(s)) {
            System.out.print(0);
        }
        if (s.contains(" ")) {
            lastIndex = s.lastIndexOf(" ");
        }
        System.out.print(len - lastIndex - 1);
    }
}
