import java.util.Scanner;

public class HJ015求int型正整数在内存中存储时1的个数 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int num = sc.nextInt();
        int count = 0;
        while(num / 2 != 0){
            if(num % 2 == 1){
                count++;
            }
            num /= 2;
            if(num == 1){
                count++;
            }
        }
        System.out.print(count);
    }

}
