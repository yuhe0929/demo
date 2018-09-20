package pearls;

import org.junit.Test;

import java.util.Arrays;
import java.util.BitSet;

/**
 * @author yuhea
 * @date 17:17 2018/7/8
 */
public class BitSetSortTest {

    @Test
    public void sort() {
        int[] data = {1, 3, 46, 8, 86, 54, 6, 7};
        int max = Arrays.stream(data).max().getAsInt();
        BitSet set = new BitSet(max + 1);

        Arrays.stream(data).forEach(i -> set.set(i));

        StringBuilder s = new StringBuilder();
        s.append("[");

        for (int i = 0; i < set.size(); i++) {
            if (set.get(i)) {
                s.append(i + " ");
            }
        }
        s.append("]");
        System.out.println(s.toString());
    }
}
