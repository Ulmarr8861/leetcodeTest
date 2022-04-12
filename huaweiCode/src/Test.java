import javax.xml.bind.Element;
import java.util.*;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3, 2, 6, 12, 3, 65, 2, 23, 1};

        List list = Arrays.asList(arr);
        int[][] arr2 = new int[5][5];
        Collections.sort(list);

        ArrayList<Integer> ab = new ArrayList<>();
        ab.add(2);
        ab.add(98);
        ab.add(1);

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                arr2[i][j] =100- (i + 1) * (j+1);
            }
        }
//        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(arr));
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        list.stream().forEach(System.out::println);

        System.out.println();
        Collections.reverse(list);
        Object[] a33 =  list.stream().toArray();
//        System.out.println(Arrays.toString(a33));
    }
}
