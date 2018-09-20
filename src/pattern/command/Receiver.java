package pattern.command;

/**
 * @author yuhea
 * @date 12:07 2018/7/15
 */
public class Receiver {
    private String name = "ABC";
    private int quantity = 10;

    public void buy() {
        System.out.println("Stock [ Name: " + name + ",Quantity: " +
                quantity + " ] bought");
    }

    public void sell() {
        System.out.println("Stock [ Name: " + name + ",Quantity: " +
                quantity + " ] sold");
    }
}
