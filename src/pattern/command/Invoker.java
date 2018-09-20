package pattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuhea
 * @date 12:24 2018/7/15
 */
public class Invoker {
    private List<Command> commandList = new ArrayList<>();

    public void takeOrder(Command Command) {
        commandList.add(Command);
    }

    public void placeOrders() {
        for (Command Command : commandList) {
            Command.execute();
        }
        commandList.clear();
    }
}
