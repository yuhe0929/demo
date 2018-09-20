import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author yuhea
 * @date 13:44 2018/4/10
 */
public class ReflectTest {
    @Test
    public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<Student1> clazz = Student1.class;

        System.out.println("**********************所有公有构造方法*********************************");
        Constructor[] conArray = clazz.getConstructors();
        for (Constructor c : conArray) {
            System.out.println(c);
        }

        System.out.println("************所有的构造方法(包括：私有、受保护、默认、公有)***************");
        conArray = clazz.getDeclaredConstructors();
        for (Constructor c : conArray) {
            System.out.println(c);
        }

        System.out.println("*****************获取公有、无参的构造方法*******************************");
        Constructor<Student1> con = clazz.getConstructor(null);
        System.out.println("con = " + con);

        Object obj = con.newInstance();
        Student1 stu = (Student1) obj;

        System.out.println("******************获取私有构造方法，并调用*******************************");
        con = clazz.getDeclaredConstructor(char.class);
        System.out.println(con);

        con.setAccessible(true);
        obj = con.newInstance('h');
        stu = (Student1) obj;
    }

    @Test
    public void testProxy() {
        RealObject real = new RealObject();
        ProxyInterface proxy = (ProxyInterface) Proxy.newProxyInstance(ProxyInterface.class.getClassLoader(), new Class[]{ProxyInterface.class},
                new ProxyObject(real));
        proxy.say();

    }



    interface ProxyInterface {
        void say();
    }

    class RealObject implements ProxyInterface {

        @Override
        public void say() {
            System.out.println("Proxy 1");
        }
    }

    class ProxyObject implements InvocationHandler {
        private Object proxied = null;

        public ProxyObject() {

        }

        public ProxyObject(Object proxied) {
            this.proxied = proxied;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("this is proxyObject");
            return method.invoke(proxied, args);
        }
    }
}
