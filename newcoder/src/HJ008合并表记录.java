import java.util.*;

public class HJ008合并表记录 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = Integer.parseInt(sc.nextLine());
        Map<Integer, Integer> map = new TreeMap<>();
        String[] line = new String[2];
        Integer[] nums = new Integer[2];
        for(int i = 0; i < total; i++) {
            line = sc.nextLine().split(" ");
            nums[0] = Integer.parseInt(line[0]);
            nums[1] = Integer.parseInt(line[1]);
            if (map.containsKey(nums[0])) {
                map.put(nums[0], map.get(nums[0]) + nums[1]);
            }else {
                map.put(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
            }
        }
        Iterator<Map.Entry<Integer,Integer>> it = map.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<Integer, Integer> map1 = it.next();
            System.out.println(map1.getKey() + " " + map1.getValue());
        }
    }
}
