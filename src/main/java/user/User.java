package user;

import questions.Anwser;
import questions.Question;

public class User {
    private int iUserID;
    private String sUserName;
    private Anwser[] anwUSersAnwsers;

    public User(int iUserID, String sUserName){
        this.iUserID = iUserID;
        this.sUserName = sUserName;
    }

    public void anwserQuestion(Question qQuestion){

    }
    public void setiUserID(int iUserID) {
        this.iUserID = iUserID;
    }

    public void setsUserName(String sUserName) {
        this.sUserName = sUserName;
    }

    public Anwser[] getAnwUSersAnwsers() {
        return anwUSersAnwsers;
    }

    public int getiUserID() {
        return iUserID;
    }

    public String getsUserName() {
        return sUserName;
    }
}
