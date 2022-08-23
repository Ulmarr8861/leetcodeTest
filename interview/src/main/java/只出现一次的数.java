import java.util.*;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现一次的元素。
 */
public class 只出现一次的数 {
    //使用异或

    /**
     * 根据前面找一个不同数的思路算法，在这里把所有元素都异或，那么得到的结果就是那两个只出现一次的元素异或的结果。
     *
     * 然后，因为这两个只出现一次的元素一定是不相同的，所以这两个元素的二进制形式肯定至少有某一位是不同的，即一个为 0 ，另一个为 1 ，现在需要找到这一位。
     *
     * 根据异或的性质 任何一个数字异或它自己都等于 0，得到这个数字二进制形式中任意一个为 1 的位都是我们要找的那一位。
     *
     * 再然后，以这一位是 1 还是 0 为标准，将数组的 n 个元素分成两部分。
     *
     * 将这一位为 0 的所有元素做异或，得出的数就是只出现一次的数中的一个
     *
     * 将这一位为 1 的所有元素做异或，得出的数就是只出现一次的数中的另一个。
     *
     * 这样就解出题目。忽略寻找不同位的过程，总共遍历数组两次，时间复杂度为O(n)。
     */
    public static int[] findOne1(int[] nums) {
        int tmp = 0;
        List<Integer> groupOne = new ArrayList();
        List<Integer> groupZero = new ArrayList();
        for (int num : nums) {
            tmp = tmp ^ num;
        }

        for (int num : nums) {
            if ((num & tmp) == 0) {
                groupZero.add(num);
            } else {
                groupOne.add(num);
            }
        }

        int one = 0;
        for (Integer num : groupOne) {
            one = num ^ one;
        }
        int zero = 0;
        for (Integer num : groupZero) {
            zero ^= num;
        }

        return new int[]{one, zero};
    }
    //使用Set
    public static int findOne(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        return set.iterator().next();
    }

    public static void main(String[] args) {
        int[] result = findOne1(new int[]{2, 2, 3, 3, 1, 1, 6, 6, 8, 10});
        Arrays.stream(result).forEach(System.out::println);
    }

}
