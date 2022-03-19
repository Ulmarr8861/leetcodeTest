import java.util.Scanner;

public class HJ002计算某字符出现次数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入一个由字母和数字以及空格组成的字符串：");
        String s = sc.next().toLowerCase();
        System.out.println("输入一个字符:");

        String target = sc.next().toLowerCase();
        char[] chars = s.toCharArray();
        int result = 0;
        for (char key : chars) {
            if (key == target.charAt(0)) {
                result++;
            }
        }
        System.out.print(result);
    }
}
