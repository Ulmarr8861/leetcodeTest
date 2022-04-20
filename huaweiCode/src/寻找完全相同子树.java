import java.util.*;

//[1,4,3,1,null,2,null,null,null,null,null,1,null,null,null]
public class 寻找完全相同子树 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String in = input.nextLine();
        String to = "";
        for (int i = 0; i < in.length(); i++) {
            to += in.charAt(i);
        }
        String[] ss = to.split(",");
        Integer[] tree = new Integer[ss.length+1];
        for (int i = 0; i < ss.length; i++) {
            if (ss[i].charAt(0) >= '0' && ss[i].charAt(0) <= '9') {
                tree[i + 1] = Integer.parseInt(ss[i]);
            }
        }
        String ans = solve(tree);
        if (ans.length()<2) {
            System.out.println(-1);
        } else {
            System.out.println('[');
            for (int i = 0; i < ans.length(); i++) {
                if (ans.charAt(i) == '0') {
                    System.out.println("null");
                } else {
                    System.out.println(ans.charAt(i));
                }
                if (i==ans.length()-1) {
                    System.out.println(']');
                } else {
                    System.out.println(',');
                }

            }
        }
    }

    private static String solve(Integer[] input) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 2; i < input.length; i++) {
            if (input[i] == null) {
                continue;
            } else {
                String s = getSon(input, i);
                if (map.containsKey(s)) {
                    map.put(s, map.get(s) + 1);
                } else {
                    map.put(s, 1);
                }
            }
        }
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        String ans = "";
        Iterator<Map.Entry<String, Integer>> it = entries.iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (value > 1) {
                if (ans.length() < key.length()) {
                    ans = key;
                }
            }
        }
        return ans;
    }

    private static String getSon(Integer[] input, int k) {
        Queue<Integer> queue = new LinkedList<>();
        String ans = "";
        queue.offer(k);
        while (!queue.isEmpty()) {
            Integer tmp = queue.element();
            queue.poll();

            if (input[tmp] != null) {
                ans += input[tmp].toString();
            } else {
                ans += "0";
            }
            //左节点
            if (tmp * 2 < input.length) {
                queue.add(tmp * 2);
            }
            //右节点
            if (tmp * 2 + 1 < input.length) {
                queue.add(tmp * 2 + 1);
            }
        }
        //从最下层开始   去除一层全为空的部分
        int p = (ans.length() + 1) / 2;
        int end = ans.length() - 1;
        while (true) {
            int all0 = 1;
            for (int i = end; i > end - p; i--) {
                if (ans.charAt(i) != '0') {
                    all0 = 0;
                }
            }
            if (all0 == 1) {
                end -= p;
                p /= 2;
            } else {
                break;
            }
        }
        String ret = "";
        for (int i = 0; i < end; i++) {
            ret += ans.charAt(i);
        }
        return ret;
    }


}
