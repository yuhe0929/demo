import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author yuhea
 * @date 10:22 2018/4/12
 */
@Aspect
public class NameAnnotationProcessor {
    @Pointcut("@within(annotation.Name) || @annotation(annotation.Name)")
    private void name() {
    }

    @Before("name()")
    public void before(JoinPoint point) {
        System.out.println("before");
        System.out.println(point.getSignature().getName());
    }
}
