package questions;

public class Question {
    private  Integer iQuestionId;
    private String sQuestionText;

    public Question(Integer iQuestionId, String sSquestionText){
        this.iQuestionId = iQuestionId;
        this.sQuestionText = sQuestionText;
    }


    public void setsQuestionText(String sQuestionText) {
        this.sQuestionText = sQuestionText;
    }

    public String getsQuestionText() {
        return sQuestionText;
    }

}
