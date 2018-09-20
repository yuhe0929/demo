import java.util.HashMap;
import java.util.Map;

/**
 * @author yuhea
 * @date 15:03 2018/4/23
 */
public enum SourceType {

    /**
     * 客户端没有传值，异常值
     */
    UNKNOW(0),
    /**
     * 国内，APP请求
     */
    DOMESTIC_MOBILE(1),
    /**
     * 国际，APP请求
     */
    INTERNATIONAL_MOBILE(2);

    private final int value;
    private static Map<Integer, SourceType> map = new HashMap<>();

    static {
        for (SourceType type : values()) {
            map.put(type.getValue(), type);
        }
    }

    SourceType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static SourceType getType(int value) {
        return map.get(value);
    }

}
