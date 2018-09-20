package consult;

import javax.annotation.PostConstruct;
import java.util.concurrent.CompletableFuture;

/**
 * @author yuhea
 * @date 22:32 2018/7/3
 */
public class AsyncProxy {
    private PaymentRemoteService paymentRemoteService;

    @PostConstruct
    public void initService() {
        paymentRemoteService = new PaymentRemoteService();
    }

    public CompletableFuture<ServiceResultModel> invokeAsync(String paymentType) {
        return CompletableFuture.supplyAsync(() -> getConsultResult(paymentType),
                ExecutorPool.executorService);
    }

    private ServiceResultModel getConsultResult(String paymentType) {
        try {
            ConsultResult result = paymentRemoteService.isEnabled(paymentType);
            if (result == null || !result.getIsEnable()) {
                /**
                 * 记录日志，这里用print函数代替
                 */
                System.out.println(paymentType + "支付方式不可用, ErrorCode:");
                System.out.println(result.getErrorCode());
                return new ServiceResultModel(paymentType, false);
            }
            return new ServiceResultModel(paymentType, true);
        } catch (Exception e) {
            System.out.println("调用支付方式" + paymentType + "接口发送异常");
            System.out.println(e.getMessage());
            return new ServiceResultModel(paymentType, false);
        }
    }
}
