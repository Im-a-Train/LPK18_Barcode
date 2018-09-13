package questions;
import user.User;

public class Anwser {

    private String sAnwserText;
    private Question qQuestion;
    private Integer iAnwser;
    private User uUser;

    public Question getqQuestion() {
        return qQuestion;
    }

    public Anwser(String sAnwserText, Question qQuestion){
        this.setsAnwserText(sAnwserText);
        this.qQuestion = qQuestion;
    }
    public void setsAnwserText(String sAnwserText) {
        this.sAnwserText = sAnwserText;
    }

    public String getsAnwserText() {
        return sAnwserText;
    }

}
