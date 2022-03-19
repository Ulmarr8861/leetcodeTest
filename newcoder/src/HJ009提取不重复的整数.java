import java.util.*;

public class HJ009提取不重复的整数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        Set<Character> map = new TreeSet<>();
        for (int i = num.length() - 1; i >= 0; i--) {
            if (!map.contains(num.charAt(i))){
                map.add(num.charAt(i));

                System.out.print(num.charAt(i));
            }
        }
    }
}
