import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author yuhea
 * @date 21:12 2017/10/23
 */
public class Test2 {

    @Test
    public void getChinese() {
        String s = "(-中文java测试1288；)";
        String str = s.replaceAll("[^0-9\u4e00-\u9fa5]", "");
        System.out.println(str);

    }

    @Test
    public void test() {
        List<Student1> list = Collections.EMPTY_LIST;
        Student1 ret = list.stream()
                .max(Comparator.comparing(Student1::getName))
                .orElse(null);

    }

    private final Pattern numPattern = Pattern.compile("[0-9]*");

    public boolean isNumeric(String str) {
        return numPattern.matcher(str).matches();
    }

    public boolean endWithNumOrChar(String str) {
        return str != null && str.matches("^.*[A-Za-z0-9]$");
    }
}
