import java.util.*;

public class HJ010字符个数统计 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Set<Character> set = new HashSet<>();
        int count = 0 ;
        for(int i = 0; i < str.length(); i++){
            if (!set.contains(str.charAt(i))){
                set.add(str.charAt(i));
                count++;
            }
        }
        System.out.print(count);

    }
}
