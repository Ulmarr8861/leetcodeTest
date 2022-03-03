package Leet146;

import com.sun.org.apache.xpath.internal.objects.XNodeSet;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Leet146 {
    int capacity;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    public Leet146(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            makeRecently(key);
            return;
        }
        if (cache.size() >= this.capacity) {
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        cache.put(key, value);
    }

    public void makeRecently(int key) {
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }
}
