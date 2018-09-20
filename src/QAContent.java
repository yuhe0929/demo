import java.util.List;

/**
 * @author yuhea
 * @date 16:57 2017/11/14
 */
public class QAContent {
    boolean isOnlyOneChoice;
    List<QA> answerList;

    public boolean isOnlyOneChoice() {
        return isOnlyOneChoice;
    }

    public void setOnlyOneChoice(boolean onlyOneChoice) {
        isOnlyOneChoice = onlyOneChoice;
    }

    public List<QA> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<QA> answerList) {
        this.answerList = answerList;
    }
}
