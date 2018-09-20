import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by yuhea on 10:00 2017/9/18
 */
public class Student1 implements Cloneable ,Comparable{
    public int age;
    private String x;
    private String name;

    Student1(String str){
        System.out.println("(默认)的构造方法 s = " + str);
    }

    //无参构造方法
    public Student1(){
        System.out.println("调用了公有、无参构造方法执行了。。。");
    }

    //有一个参数的构造方法
    private Student1(char name){
        System.out.println("姓名：" + name);
    }

    //有多个参数的构造方法
    public Student1(String name ,int age){
        System.out.println("姓名："+name+"年龄："+ age);//这的执行效率有问题，以后解决。
    }

    //受保护的构造方法
    protected Student1(boolean n){
        System.out.println("受保护的构造方法 n = " + n);
    }

    //私有构造方法
    private Student1(int age){
        System.out.println("私有的构造方法   年龄："+ age);
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private Date date;

    public Student1(String x, String name) {
        this.x = x;
        this.name = name;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return this.name;
    }


    @Override
    public int compareTo(Object o) {
        if (o instanceof  Student1){
            Student1 student1 = (Student1)o;
            return Integer.parseInt(this.name) < Integer.parseInt(((Student1) o).getName()) ? 1 : -1;
        }
        return 0;
    }
}
