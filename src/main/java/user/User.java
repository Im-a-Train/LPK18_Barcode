package user;

import questions.Anwser;
import questions.Question;

public class User {
    private String sUserID;
    private String sUserName;
    private Anwser[] anwUSersAnwsers;

    public User(String sUserID, String sUserName){
        this.sUserID = sUserID;
        this.sUserName = sUserName;
    }

    public void anwserQuestion(Question qQuestion){

    }
    public void setsUserID(String sUserID) {
        this.sUserID = sUserID;
    }

    public void setsUserName(String sUserName) {
        this.sUserName = sUserName;
    }

    public Anwser[] getAnwUSersAnwsers() {
        return anwUSersAnwsers;
    }

    public String getsUserID() {
        return sUserID;
    }

    public String getsUserName() {
        return sUserName;
    }
}
