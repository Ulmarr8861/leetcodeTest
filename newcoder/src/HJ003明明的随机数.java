import java.util.*;

public class HJ003明明的随机数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = Integer.parseInt(sc.nextLine());
        TreeSet<Integer> ts = new TreeSet<>();

        for (int i = 0; i < total; i++) {
                ts.add(Integer.valueOf(sc.nextLine()));
        }
        ts.comparator();
        Iterator it = ts.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
