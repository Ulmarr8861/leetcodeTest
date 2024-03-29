import java.util.Arrays;
import java.util.Scanner;
//https://mp.weixin.qq.com/s?__biz=MzUyNjQxNjYyMg==&mid=2247484557&idx=1&sn=739d80488fe1169a9c9ca26ecfcdfba6&chksm=fa0e6b0ccd79e21a1c2b0d99db69f6206cddddfe2367742e9de1d7d17ec35a5ce29fa4e30d63&token=110841213&lang=zh_CN#rd
/**
 * 有一种玻璃杯质量确定但未知，需要检测。
 * 有一栋100层的大楼，该种玻璃杯从某一层楼扔下，刚好会碎。
 * 现给你两个杯子，问怎样检测出这个杯子的质量，即找到在哪一层楼刚好会碎？
 */
public class 扔杯子 {
    //方法1：二分法
    /**
     * 从 50 楼扔下，没碎的话，再扔 75 楼，再没碎我扔 88 楼，依次下去貌似很快就可以锁定楼层。
     *
     * 不过，很不巧，第一次从 50 层楼扔下去就碎了，这个时候就只能从 1 层开始慢慢的的一层一层地扔，
     * 如果杯子的质量是刚好在 49 层碎掉的话，那么最差的情况是需要扔 50 次。
     */


    //方法2：分段查找区间法
    /**
     * 核心点：先分区间的扔，再慢慢地一层一层地扔。
     *
     * 举个🌰：先从第 10 楼扔，再从第 20 楼扔
     * 依次下去，如果到某一层碎掉，比如 60 层碎掉了，
     * 我再从 51 楼开始扔，这样比前面的二分法更快，因为即使又很不巧，杯子的质量比较好，
     * 在 99 楼才会刚好碎掉。这样的话，在这种最差的情况下，也只需要扔 19 次就能找到目标楼层。
     */

    //方法3：基于数学方程的方法
    /**
     假设最少尝试次数为 x ，那么，第一个杯子必须要从第 x 层扔下，因为：如果碎了，前面还有 x - 1 层楼可以尝试，如果没碎，后面还有 x-1 次机会。

     如果没碎，第一个杯子，第二次就可以从 x +（x - 1）层进行尝试，这里加上 x - 1，是因为当此时，第一个杯子碎了，第二个杯子还有可以从 x + 1 到 （ x + (x - 1) - 1 ） 层进行尝试，有 x - 2 次机会。

     如果还没碎，那第一个杯子，第三次从 x + (x - 1) + (x - 2)层尝试。不管杯子碎或者没碎，都有 x - 3 次尝试机会，依次类推。

     那么经过 x 次的尝试可以确定最高的楼层为 x + (x - 1) + (x - 2) + … + 1 = x(x+1) / 2 。

     那反过来，当最高楼层是100层，最少需要多少次呢？即 x(x+1)/2 >= 100, 得到 x >= 14 ，最少要尝试 14 次。
     */


    //方法4：动态规划
    //https://mp.weixin.qq.com/s?__biz=MzUyNjQxNjYyMg==&mid=2247484557&idx=1&sn=739d80488fe1169a9c9ca26ecfcdfba6&chksm=fa0e6b0ccd79e21a1c2b0d99db69f6206cddddfe2367742e9de1d7d17ec35a5ce29fa4e30d63&token=110841213&lang=zh_CN#rd
}
