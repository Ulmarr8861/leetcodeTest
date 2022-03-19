import java.util.Arrays;
import java.util.Scanner;

public class HJ014字符串排序 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] strs =  new String[n];
        for(int i = 0; i < n; i++){
            strs[i] = sc.nextLine();
        }
        Arrays.sort(strs);
        for(int i = 0; i < n; i++){
            System.out.println(strs[i]);
        }
    }
}
