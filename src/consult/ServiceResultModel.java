package consult;

/**
 * @author yuhea
 * @date 23:02 2018/7/3
 */
public class ServiceResultModel {
    private String payment;
    private Boolean isEnable;

    public ServiceResultModel(String payment, Boolean isEnable) {
        this.payment = payment;
        this.isEnable = isEnable;
    }

    public String getPayment() {
        return payment;
    }

    public Boolean getEnble() {
        return isEnable;
    }
}
