/**
 * @author yuhea
 * @date 21:07 2017/10/23
 */
public interface B extends A{
    @Override
    default void hello(){
        System.out.println("b");
    }
}
