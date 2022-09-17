import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N字 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Character> lists[];
        while (in.hasNext()) {
            String line = in.nextLine();
            int t = in.nextInt();
            lists = new List[t];
            for (int i = 0; i < t; i++) {
                lists[i] = new ArrayList<>();
            }
            int p = 0;//层数
            int to = 1;//1：表示向下，-1表示向上
            for (int i = 0; i < line.length(); i++) {
                lists[p].add(line.charAt(i));
                if (to > 0) {
                    if (p + to < t) {
                        p++;
                    }
                    else {
                        p--;
                        to=-1;
                    }
                }
                else {
                    if (p + to >= 0) {
                        p--;
                    }
                    else {
                        p++;
                        to=1;
                    }
                }
            }
            for(int i=0;i<t;i++){
                for(Character c:lists[i]){
                    System.out.print(c);
                }
            }
            System.out.println();
        }
    }
}