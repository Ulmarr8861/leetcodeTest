import java.util.*;
public class HJ017坐标移动 {
    static Set set = new HashSet();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] list = sc.nextLine().split(";");
        set.add("A");
        set.add("W");
        set.add("S");
        set.add("D");
        int[] index = new int[2];
        int k = 0;
        Map<String,Integer> map  = new HashMap<>();
        for(int i = 0; i< list.length; i++){
            if (list[i].length() == 0 || !judge(list[i])) {
                continue;
            }
            if (list[i].charAt(0) == 'A'){
                k = Integer.parseInt(list[i].split("A")[1]);
                index[0] -= k;
                continue;

            }
            if (list[i].charAt(0) == 'D'){
                k = Integer.parseInt(list[i].split("D")[1]);
                index[0] += k;
                continue;

            }
            if (list[i].charAt(0) == 'W'){
                k = Integer.parseInt(list[i].split("W")[1]);
                index[1] += k;
                continue;

            }
            if (list[i].charAt(0) == 'S'){
                k = Integer.parseInt(list[i].split("S")[1]);
                index[1] -= k;
                continue;

            }
        }
        System.out.print(index[0]+ ","+index[1]);
    }
    public static boolean judge(String str){
        if (!set.contains(String.valueOf(str.charAt(0)))) {
            return false;
        }
        str = str.substring(1, str.length());
        if (str.contains("A") || str.contains("S") || str.contains("W") || str.contains("D")) {
            return false;
        }
        return true;
    }
}
