package pattern.command;

/**
 * @author yuhea
 * @date 12:19 2018/7/15
 */
public class SellStockCommand implements Command {
    private Receiver abcReceiver;

    public SellStockCommand(Receiver abcReceiver) {
        this.abcReceiver = abcReceiver;
    }

    @Override
    public void execute() {
        abcReceiver.sell();
    }
}
