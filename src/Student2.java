
/**
 * Created by yuhea on 10:01 2017/9/18
 */
public class Student2 implements Cloneable {
    public String name;
    public int age;
    public City city;

    public Student2(String name, int age, City city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public Student2() {
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
