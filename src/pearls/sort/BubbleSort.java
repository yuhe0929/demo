package pearls.sort;

import org.junit.Test;

/**
 * @author yuhea
 * @date 13:49 2018/7/14
 */
public class BubbleSort {
    @Test
    public void test() {
        int[] intArray = {1, 3, 3, 46, 8, 86, 54, 6, 7};
        bubbleSort(intArray);
        printArray(intArray);

    }

    /**
     * 分类 -------------- 内部比较排序
     * 数据结构 ---------- 数组
     * 最差时间复杂度 ---- O(n^2)
     * 最优时间复杂度 ---- 如果能在内部循环第一次运行时,使用一个旗标来表示有无需要交换的可能,可以把最优时间复杂度降低到O(n)
     * 平均时间复杂度 ---- O(n^2)
     * /所需辅助空间 ------ O(1)
     * /稳定性 ------------ 稳定
     */
    private void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }

    @Test
    public void testSelect() {
        int[] intArray = {1, 3, 3, 46, 8, 86, 54, 1, 6, 7};
        selectSort(intArray);
        printArray(intArray);
    }

    private void printArray(int[] intArray) {
        for (int a : intArray) {
            System.out.print(a + " ");
        }
    }

    /**
     * 选择排序
     */
    private void selectSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(a, i, min);
            }
        }
    }

    @Test
    public void testFastSort() {
        int[] intArray = {6,3,7,4,1};
        fastSort(intArray, 0, intArray.length - 1);
        printArray(intArray);
    }

    /**
     * 快速排序
     */
    private void fastSort(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int index = partition(a, lo, hi);
        fastSort(a, lo, index - 1);
        fastSort(a, index + 1, hi);
    }

    private int partition(int[] a, int lo, int hi) {
        int key = a[lo];
        while (lo < hi) {
            while (a[hi] >= key && hi > lo) {
                hi--;
            }
            a[lo] = a[hi];
            while (a[lo] <= key && hi > lo) {
                lo++;
            }
            a[hi] = a[lo];
        }
        a[hi] = key;
        return hi;
    }

    private void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
