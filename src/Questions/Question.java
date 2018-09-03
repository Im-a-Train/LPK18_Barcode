package Questions;

public class Question {
    private String sQuestionText;
    private Anwser aQuestionAnwser;

    public void  setaQuestionAnwser(Anwser aQuestionAnwser) {
        this.aQuestionAnwser = aQuestionAnwser;
    }

    public void setsQuestionText(String sQuestionText) {
        this.sQuestionText = sQuestionText;
    }

    public String getsQuestionText() {
        return sQuestionText;
    }

    public Anwser getaQuestionAnwser() {
        return aQuestionAnwser;
    }
}
