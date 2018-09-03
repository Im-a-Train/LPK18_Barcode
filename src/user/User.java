package user;

import Questions.Anwser;

public class User {
    private int iUserID;
    private String sUserName;
    private Anwser[] anwUSersAnwsers;

    public void setAnwUSersAnwsers(Anwser[] anwUSersAnwsers) {
        this.anwUSersAnwsers = anwUSersAnwsers;
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
