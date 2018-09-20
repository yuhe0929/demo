import org.junit.Test;

/**
 * @author yuhea
 * @date 10:35 2018/4/24
 */
public class EnumTest {

    @Test
    public void testEnum() {
        for (int i = 0; i <= 4; i++) {
            System.out.println(getType(i));
        }
    }

    private String getType(int sourceType) {
        SourceType type = SourceType.getType(sourceType);
//        if (type == null) {
//            return "null";
//        }
        switch (type) {
            case DOMESTIC_MOBILE:
                return "d";
            case INTERNATIONAL_MOBILE:
                return "i";
            default:
                return "default";
        }
    }
}
