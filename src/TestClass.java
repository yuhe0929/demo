/**
 * @author yuhea
 * @date 20:54 2018/1/22
 */
public class TestClass {
    private int count;

    public TestClass(int count) {
        this.count = count;
    }

    public void add(int a) {
        count += a;
    }

    public int getCount() {
        return count;
    }
}
