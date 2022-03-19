import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HJ012字符串反转 {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            List list = new ArrayList();
            for(int i  = 0; i < str.length(); i++){
                list.add(str.charAt(i));
            }
            Collections.reverse(list);
            for(int i = 0; i < str.length(); i++){
                System.out.print(list.get(i));

            }
        }
}
