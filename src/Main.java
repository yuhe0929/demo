public class Main {
    public static void main(String[] args) {
//        CompletableFuture
//                .supplyAsync(() -> {
//                    sleepAndPrint(1);
//                    return null;
//                })
//                .thenCompose(o ->
//                        CompletableFuture
//                                .runAsync(() -> {
//                                    sleepAndPrint(3);
//                                }).thenRunAsync(() -> sleepAndPrint(4)))
//                .thenRunAsync(() ->
//                        sleepAndPrint(2)
//                ).join();

        Student2 student2 = new Student2();
        testAnnotation();
    }

    private static void sleepAndPrint(int x) {
        try {
            Thread.sleep(x * 1000L);
            System.out.println(x);
        } catch (InterruptedException e) {
            e.printStackTrace();


        }
    }

    public static void testAnnotation() {
        System.out.println("test Annotation");
    }
}
