package consult;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author yuhea
 * @date 22:34 2018/7/3
 */
public class ExecutorPool {

    /**
     * 远程接口调用使用的线程池
     */
    public static final ExecutorService executorService = new ThreadPoolExecutor(
            Runtime.getRuntime().availableProcessors() - 1,
            50,
            1,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>());
}
