package pattern.command;

import org.junit.Test;

/**
 * @author yuhea
 * @date 12:26 2018/7/15
 */
public class CommandClient {

    @Test
    public void testCommand() {
        Receiver abcReceiver = new Receiver();

        BugStockCommand bugStockCommand = new BugStockCommand(abcReceiver);
        SellStockCommand sellStockOrderCommand = new SellStockCommand(abcReceiver);

        Invoker invoker = new Invoker();
        invoker.takeOrder(bugStockCommand);
        invoker.takeOrder(sellStockOrderCommand);

        invoker.placeOrders();
    }
}
