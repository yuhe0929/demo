import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author yuhea
 * @date 20:32 2018/4/9
 */
public class AsyncTest {
    @Test
    public void testSupply() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> getFullName("yu", "he"));
        System.out.println(future.join() + " " + Thread.currentThread().getName());
    }

    @Test
    public void testThenApply() {
        Executor executor = Executors.newFixedThreadPool(4);
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> getFullName("yu", "he"), executor);
        CompletableFuture<String> future2 = future.thenApply(name -> sayHello(name));
        System.out.println("this is main Thread");
        System.out.println(future2.join());
    }

    @Test
    public void testAsync() {
        CompletableFuture.completedFuture(1).thenApply(v -> getFullName("yu", "he"));

        //Thread.sleep(100);
    }

    public String getFullName(String firstName, String lastName) {
        CompletableFuture<String> upperFirstName = CompletableFuture.supplyAsync(() -> upperFirstCase(firstName));
        ;
        //CompletableFuture<String> upperLastName = CompletableFuture.supplyAsync(() -> );

        CompletableFuture<String> fullName = upperFirstName.thenCompose(f -> CompletableFuture.supplyAsync(() -> f + " " + upperFirstCase(lastName)));
        //CompletableFuture<String> fullName = upperFirstName.thenCombine(upperLastName, (f, l) -> f + " " + l);
        //String fullName = upperFirstName + " " + upperLastName;
        System.out.println("getFullName method:  " + Thread.currentThread().getName());
        return fullName.join();
    }

    public String upperFirstCase(String str) {
        char[] ch = str.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char) (ch[0] - 32);
        }
        String s = new String(ch);
        //System.out.println(s + " " + Thread.currentThread().getName());
        return s;
    }

    public String sayHello(String name) {
        System.out.println("saySomeThing: " + Thread.currentThread().getName());
        return "Hello " + name;
    }
}
