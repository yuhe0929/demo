import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author yuhea
 * @date 11:34 2018/4/20
 */
public class TimeTest {
    @Test
    public void testTime() {
        LocalDate localDate = LocalDate.now();
        Timestamp timestamp = Timestamp.valueOf(localDate.atStartOfDay());
    }

    @Test
    public void testEmptyList() {
        List<String> list = Collections.emptyList();
        list.add("s");
    }
}
