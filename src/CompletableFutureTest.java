import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

/**
 * @author yuhea
 * @date 20:45 2018/3/29
 */
public class CompletableFutureTest {

    @Test
    public void test() {
        long start = System.currentTimeMillis();
        /**
         * 新建一个list
         */
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }

        /**
         * parallelStream
         */
        //List<Integer> rs = list.parallelStream().map(this::print).collect(Collectors.toList());

//        List<CompletableFuture<Integer>> futures = list.stream()
//                .map(o -> CompletableFuture.supplyAsync(() -> print(o))).collect(Collectors.toList());
//
//        List<Integer> rs = futures.stream().map(CompletableFuture::join).collect(Collectors.toList());

        /**
         *   结合stream
         */
//        List<Integer> rs = list.stream()
//                .map(o -> CompletableFuture.supplyAsync(() -> print(o)))
//                .map(a -> a.join())
//                .collect(Collectors.toList());


        Executor executor = Executors.newFixedThreadPool(20);
        List<CompletableFuture<Integer>> futures = list.stream()
                .map(o -> CompletableFuture.supplyAsync(() -> print(o), executor))
                .collect(Collectors.toList());

        List<Integer> rs = futures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

        Long end = System.currentTimeMillis();
        System.out.println("main thread: " + Thread.currentThread().getName());
        System.out.println(rs);
        System.out.println("time: " + (end - start));
    }

    /**
     * 延时一秒， 打印输入s，输出s
     */
    private Integer print(Integer s, int timeout) {
        try {
            Thread.sleep(timeout);
            System.out.println(s + "  use thread name: " + Thread.currentThread().getName());
            return s;
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

    private void onlyPrint(Integer s, int timeout) {
        try {
            Thread.sleep(timeout);
            System.out.println(s + "  use thread name: " + Thread.currentThread().getName());
            //return s;
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

    private Integer print(Integer s) {
        return print(s, 1000);
    }

    @Test
    public void thenComposeTest() {
        long start = System.currentTimeMillis();
        Integer i = 10;
        CompletableFuture<Integer> futrue1 = CompletableFuture.supplyAsync(() -> print(i));
        futrue1.thenComposeAsync(s -> CompletableFuture.supplyAsync(() -> intToString(i + 1)));

        //System.out.println(futrue2.join().equals("11"));
        System.out.println("time: " + (System.currentTimeMillis() - start));

    }

    private String intToString(Integer i) {
        try {
            Thread.sleep(500);
            System.out.println(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
        return i.toString();
    }

    @Test
    public void completeTest() {
        CompletableFuture<Integer> futrue1 = CompletableFuture.supplyAsync(() -> print(100));
        futrue1.complete(1);
        System.out.println(futrue1.join());
//        futrue1.completeExceptionally(new Exception("future exception"));
//        futrue1.join();
    }

    @Test
    public void thenApplyTest() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "future complete";
        });

        CompletableFuture<String> f = future.thenApply(s -> {
            System.out.println(Thread.currentThread().getName());
            return s + " apply";
        });
        System.out.println(f.join());
    }

    @Test
    public void thenApply() throws InterruptedException {
        long start = System.currentTimeMillis();
        int s = 1;
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int r = print(s);
            System.out.println("future1 complete time : " + (System.currentTimeMillis() - start));
            return r;
        });

        future.thenApply(i -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("future2 complete time : " + (System.currentTimeMillis() - start));
            return i * 10;
        }).thenAcceptAsync(i -> System.out.println(i)).join();
        System.out.println("get future2: " + (System.currentTimeMillis() - start));


        //Thread.sleep(2000);
    }


    @Test
    public void testException() {
//          CompletableFuture<String> future1 = generateException(true, 1);
//         CompletableFuture<String> future2 = generateException(false, 2);
        CompletableFuture<String> future = getException(true);
        future.thenApply(s -> {
            System.out.println(s);
            return "s";
        }).exceptionally(e -> {
            System.out.println(e.getMessage());
            return " ";
        });

//        future.handle((s,ex) -> {
//            if (s != null){
//                System.out.println(s);
//                return s;
//            }
//
//            if (ex != null){
//                System.out.println(ex.getMessage());
//                return "";
//            }
//            return "";
//        });

//        future1.thenCombine(future2, (s1, s2) -> {
//            System.out.println(s1 + s2);
//            return s1 + s2; b
//        }).exceptionally(e -> {
//            System.out.println(e.getMessage());
//            return "";
//        });

        //future.join();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private CompletableFuture<String> getException(boolean isThrow) {
        CompletableFuture<String> f = generateException(isThrow, 0);
        return f.thenApply(s -> "sucessful  " + s);
    }

    private CompletableFuture<String> generateException(boolean isThrow, int i) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "no exception" + i + "  ");
        String s = null;
        if (isThrow) {
            future.completeExceptionally(new Exception("throw a Exception" + i));
        }
        return future;
    }

    @Test
    public void Then() {
        CompletableFuture.supplyAsync(
                () -> print(1, 1000))
                .thenRunAsync(new Runnable() {
                    @Override
                    public void run() {
                        CompletableFuture<Void> f = CompletableFuture.runAsync(() -> onlyPrint(7, 4000));
                    }
                })
                .thenRunAsync(() -> print(3, 3000))
                .join();

    }

    @Test
    public void testAsync() {
        // CompletableFuture<String> f = CompletableFuture.supplyAsync(() -> getString().join());
//        CompletableFuture.supplyAsync(() -> "x").thenCompose(x -> {
//            return getString();
//        });

        CompletableFuture.completedFuture(1).thenComposeAsync(v -> CompletableFuture.supplyAsync(() -> getString())).join();

        // CompletableFuture.supplyAsync(() -> f).join();
    }

    private String getString() {
        System.out.println("in " + Thread.currentThread().getName());
        return "getString method";
    }

    @Test
    public void testFuture() {
        ExecutorService executor = Executors.newCachedThreadPool();
        long start = System.currentTimeMillis();
        Future<Double> future = executor.submit(new Callable<Double>() {
            @Override
            public Double call() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return 2.1D;
            }
        });
        doSomethingElse();  //同步执行
        try {
            //Double result = future.get(); //可能会永久阻塞
            Double result = future.get(2, TimeUnit.SECONDS);
            System.out.println("time: " + (System.currentTimeMillis() - start));
        } catch (ExecutionException ee) {
            // 计算抛出一个异常
        } catch (InterruptedException ie) {
            // 当前线程在等待过程中被中断
        } catch (TimeoutException te) {
            // 在Future对象完成之前超过已过期
        }
    }

    public void doSomethingElse() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("doSomeThing Done!");
    }

    @Test
    public void testNull() {
        CompletableFuture<Double> f = CompletableFuture.supplyAsync(() -> sub(1, 0));
        Double s = f.join();
        System.out.println(s);
    }

    private Double sub(double a, double b) {
        try {
            String s = null;
            s.equals(" ");
            return 1.0D;
        } catch (Exception e) {
            return null;
        }
    }

    @Test
    public void testExp() {
        Calendar c = Calendar.getInstance();
        gException(false).thenApply(s -> {
            System.out.println(s);
            return "x";
        }).exceptionally(e -> {
            System.out.println(e.getMessage());
            return "s";
        });
    }

    private CompletableFuture<String> gException(boolean is) {
        if (is) {
            return CompletableFuture.completedFuture("ss");
        } else {
            CompletableFuture<String> c = new CompletableFuture<>();
            c.completeExceptionally(new Exception("error"));
            return c;
        }
    }
}