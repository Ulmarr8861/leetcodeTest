import java.util.Scanner;
public class HJ005进制转换 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String line = sc.nextLine().substring(2);
            System.out.println(Integer.parseInt(line,16));
        }
    }
}

