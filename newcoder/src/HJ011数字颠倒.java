import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HJ011数字颠倒 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        List<Character> charList = new ArrayList<>();
        for (int i = 0 ; i < str.length() ; i++){
            charList.add(str.charAt(i));
        }
        Collections.reverse(charList);
        for (int i = 0; i < str.length();i++){
            System.out.print(charList.get(i));
        }
    }
}
