package consult;

/**
 * @author yuhea
 * @date 22:29 2018/7/3
 */
public class ConsultResult {

    public ConsultResult(boolean isEnable, String errorCode) {
        this.isEnable = isEnable;
        this.errorCode = errorCode;
    }

    /**
     * 咨询结果是否可用
     */
    private boolean isEnable;

    /**
     * 错误码
     */
    private String errorCode;

    public boolean getIsEnable() {
        return isEnable;
    }

    public String getErrorCode() {
        return errorCode;
    }
}