package consult;

/**
 * @author yuhea
 * @date 22:30 2018/7/3
 */
public class PaymentRemoteService {

    public ConsultResult isEnabled(String paymentType) throws Exception{

        /**
         * mock 远程接口返回结果
         */
        return new ConsultResult(true, null);
    }
}
