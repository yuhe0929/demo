package pattern.command;

/**
 * @author yuhea
 * @date 12:18 2018/7/15
 */
public class BugStockCommand implements Command {
    private Receiver receiver;

    public BugStockCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.buy();
    }
}
