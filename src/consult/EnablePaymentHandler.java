package consult;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @author yuhea
 * @date 22:55 2018/7/3
 */
public class EnablePaymentHandler {
    private AsyncProxy asyncProxy = new AsyncProxy();

    public Map<String, Boolean> checkPaynent(List<String> paymentList) {
        List<CompletableFuture<ServiceResultModel>> futureList = paymentList.stream()
                .map(asyncProxy::invokeAsync)
                .collect(Collectors.toList());

        List<ServiceResultModel> resultList = futureList.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

        return resultList.stream()
                .collect(Collectors.toMap(ServiceResultModel::getPayment, ServiceResultModel::getEnble));
    }
}
