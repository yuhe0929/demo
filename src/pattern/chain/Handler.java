package pattern.chain;

public class Handler {
    private Handler next;
    private int level;

    public Handler(int level){
        this.level = level;
    }
}
