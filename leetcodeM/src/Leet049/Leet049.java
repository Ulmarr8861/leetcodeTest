package Leet049;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Leet049 {

    //方法一：排序
    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(str -> {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            return new String(array);
        })).values());
    }
}
